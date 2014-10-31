public class Factor implements NumericProduction {

	Op op;
	Factor factor;

	public Factor() {
		op = new Op();
	}

	public static boolean isFactor(int token) {
		return Op.isOp(token); // Factor = { Op | Op * Factor }
	}

	public void parse(Tokens tokens) {
		Reporter.Assert(tokens.hasCurrent() && isFactor(tokens.getToken()),
				"Factor");
		op.parse(tokens);

		if (tokens.hasCurrent() && tokens.getToken() == 24) {
			tokens.skip();
			factor = new Factor();
			factor.parse(tokens);
		}
	}

	public int value() {
		int result = op.value();
		return result;
	}

	public void print(int tabStop) {
		op.print(tabStop);
		if (factor != null) {
			System.out.print(" * ");
			factor.print(tabStop);
		}
	}
}

public class Factor implements Production {

	Production op;
	Production factor;

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

		if (tokens.hasCurrent() && tokens.equals("*")) {
			factor = new Factor();
			factor.parse(tokens);
		}
	}

	public void execute() {

	}

	public void print(int tabStop) {
		op.print(tabStop);
		if (factor != null)
			factor.print(tabStop);
	}
}

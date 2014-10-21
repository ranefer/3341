public class Factor implements Production {

	Production op;
	Production factor;

	boolean recursive;

	public Factor() {
		op = new Op();
		factor = new Factor();
		recursive = false;
	}

	public static boolean isFactor(int token) {
		return Op.isOp(token); // Factor = { Op | Op * Factor }
	}

	public void parse(Tokens tokens) {
		Reporter.Assert(tokens.hasCurrent() && isFactor(tokens.getToken()),
				"Factor");
		op.parse(tokens);

		if (tokens.hasCurrent() && tokens.equals("*")) {
			recursive = true;
			factor.parse(tokens);
		}
	}

	public void execute() {

	}

	public void print() {
		op.print();
		if (recursive)
			factor.print();
	}
}

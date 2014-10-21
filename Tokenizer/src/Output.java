public class Output implements Production {

	public static boolean isOutput(int token) {
		return token == 11;
	}

	public void parse(Tokens symbols) {
		Reporter.Assert(symbols.hasCurrent() && isOutput(symbols.getToken()),
				"Output");
		symbols.skip();

		Id.parse(symbols);
		SemiColon.parse(symbols);
	}

	public void execute() {

	}

	public void print() {

	}

}

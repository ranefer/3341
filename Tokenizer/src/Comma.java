public class Comma implements Production {

	public static boolean isComma(int token) {
		return token == 13;
	}

	public void parse(Tokens symbols) {
		Reporter.Assert(symbols.hasCurrent() && isComma(symbols.getToken()),
				";");
		symbols.skip();
	}

	public void execute() {

	}

	public void print() {

	}

}

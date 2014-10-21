public class Input implements Production {

	Production id;

	public static boolean isInput(int token) {
		return token == 10;
	}

	public void parse(Tokens symbols) {
		Reporter.Assert(symbols.hasCurrent() && isInput(symbols.getToken()),
				"read");
		symbols.skip();

		id.parse(symbols);

		SemiColon.parse(symbols);
	}

	public void execute() {

	}

	public void print() {
		System.out.println("read");
		id.print();
		SemiColon.print();
	}

}

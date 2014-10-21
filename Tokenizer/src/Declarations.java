public class Declarations implements Production {

	Production id;
	Production declaration;

	String symbol;

	public Declarations() {
		id = new Id();
		declaration = new Declarations();
	}

	public static boolean isDeclaration(int token) {
		return token == 4; // int
	}

	public void parse(Tokens symbols) {
		Reporter.Assert(
				symbols.hasCurrent() && isDeclaration(symbols.getToken()),
				"int");
		symbols.skip();

		id.parse(symbols);

		// TODO : recursive

		if (isDeclaration(symbols.getToken()))
			declaration.parse(symbols);

		SemiColon.parse(symbols);
	}

	public void execute() {

	}

	public void print() {
		System.out.print("int ");
		id.print();
		declaration.print();
		System.out.println(";");
	}

}

public class Declarations implements Production {

	Production id;
	Production declaration;

	String symbol;
	boolean topLevelDeclaration = false;

	public Declarations() {
		id = new Id();
	}

	public static boolean isDeclaration(int token) {
		return token == 4 || Comma.isComma(token); // int ,
	}

	public void parse(Tokens tokens) {
		declaration = new Declarations();
		topLevelDeclaration = true;
		Reporter.Assert(
				tokens.hasCurrent() && isDeclaration(tokens.getToken()),
				"int or ','");
		if (Comma.isComma(tokens.getToken()))
			topLevelDeclaration = false;

		tokens.skip();

		id.parse(tokens);

		if (isDeclaration(tokens.getToken()))
			declaration.parse(tokens);

		if (topLevelDeclaration)
			SemiColon.parse(tokens);
	}

	public void execute() {

	}

	public void print(int tabStop) {
		if (topLevelDeclaration) {
			System.out.print("int ");
			id.print(tabStop);
			declaration.print(tabStop);
			System.out.println(";");

		} else if (declaration != null) {
			Comma.print();
			id.print(tabStop);
			declaration.print(tabStop);
		}
	}
}

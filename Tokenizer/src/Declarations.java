public class Declarations implements Production {

	Production idList;

	String symbol;

	public Declarations() {
		idList = new IdList();
	}

	public static boolean isDeclaration(int token) {
		return token == 4; // int
	}

	public void parse(Tokens tokens) {
		Reporter.Assert(
				tokens.hasCurrent() && isDeclaration(tokens.getToken()),
				"int");

		tokens.skip();
		idList.parse(tokens);
		SemiColon.parse(tokens);
	}

	public void execute() {

	}

	public void print(int tabStop) {
			System.out.print("int ");
			idList.print(tabStop);
			SemiColon.print();
	}
}

public class Declarations implements Production {

	IdList idList;

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

	public void print(int tabStop) {

            Tab.print(tabStop);
			System.out.print("int ");
			idList.print(tabStop);
            
            Tab.print(tabStop);
			SemiColon.print();
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
	}
}

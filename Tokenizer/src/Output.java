public class Output implements Production {

	Id id;

	public Output() {
		id = new Id();
	}

	public static boolean isOutput(int token) {
		return token == 11;
	}

	public void parse(Tokens tokens) {
		Reporter.Assert(tokens.hasCurrent() && isOutput(tokens.getToken()),
				"Output");
		tokens.skip();

		Reporter.Assert(Id.isDeclared(tokens.getSymbol()), "declared id");

		id.parse(tokens);
		SemiColon.parse(tokens);
	}

	public void execute() {
		int length = id.getLongestIdentifierLength();
		Tab.print(length - id.name.length());
		Reporter.Assert(id.isInitialized(), "initialized id");

		System.out.println(id.name + " =  " + id.value());
	}

	public void print(int tabStop) {
		System.out.print("write ");
		id.print(tabStop);
		SemiColon.print();
	}

}

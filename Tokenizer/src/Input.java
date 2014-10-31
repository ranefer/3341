public class Input implements Production {

	Id id;

	public Input() {
		id = new Id();
	}

	public static boolean isInput(int token) {
		return token == 10;
	}

	public void parse(Tokens tokens) {
		Reporter.Assert(tokens.hasCurrent() && isInput(tokens.getToken()),
				"read");
		tokens.skip();

		id.parse(tokens);

		SemiColon.parse(tokens);
	}

	public void execute() {
		int value = Integer.valueOf(Data.next());
		id.setValue(value);
	}

	public void print(int tabStop) {
		Tab.print(tabStop);
		System.out.print("read ");
		id.print(tabStop);
		SemiColon.print();
	}

}

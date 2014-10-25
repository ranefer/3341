public class Input implements Production {

	Id id;

	public Input() {
		id = new Id();
	}

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
		int value = Integer.valueOf(Data.next());
		id.setValue(value);
	}

	public void print(int tabStop) {
		Tab.print(tabStop);
		System.out.print("read ");
		id.print(tabStop);

		Tab.print(tabStop);
		SemiColon.print();
	}

}

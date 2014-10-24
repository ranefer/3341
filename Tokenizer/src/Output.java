public class Output implements Production {

	Id id;

	public Output() {
		id = new Id();
	}

	public static boolean isOutput(int token) {
		return token == 11;
	}

	public void parse(Tokens symbols) {
		Reporter.Assert(symbols.hasCurrent() && isOutput(symbols.getToken()),
				"Output");
		symbols.skip();

		id.parse(symbols);
		SemiColon.parse(symbols);
	}

	public void execute() {
		System.out.println(id.name + ":  " + id.value());
	}

	public void print(int tabStop) {
		System.out.print("write ");
		id.print(tabStop);
		SemiColon.print();
	}
}

public class Id implements Production {

	Production id;

	public Id() {

	}

	public static boolean isId(int token) {
		return token == 32;
	}

	public void parse(Tokens symbols) {
		Reporter.Assert(symbols.hasCurrent() && isId(symbols.getToken()), "Id");
		symbols.skip();

	}

	public void execute() {

	}

	public void print() {
		id.print();
		Comma.print();
	}
}

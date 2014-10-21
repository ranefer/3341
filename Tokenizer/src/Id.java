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

		if (symbols.hasCurrent() && Comma.isComma(symbols.getToken())) {
			Comma.parse(symbols);
			id.parse(symbols);
		}
	}

	public void execute() {

	}

	public void print() {
		ip.parse;
	}
}

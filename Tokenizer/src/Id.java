public class Id implements Production {

	String id;

	public Id() {
		id = "";
	}

	public static boolean isId(int token) {
		return token == 32;
	}

	public void parse(Tokens tokens) {
		Reporter.Assert(tokens.hasCurrent() && isId(tokens.getToken()), "Id");
		id = String.valueOf(tokens.getToken());
		tokens.skip();
	}

	public void execute() {

	}

	public void print() {
		System.out.print(id);
	}
}

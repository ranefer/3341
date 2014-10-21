public class SemiColon implements Terminal {

	public static boolean isSemiColon(int token) {
		return token == 12;
	}

	public static void parse(Tokens tokens) {
		Reporter.Assert(
				tokens.hasCurrent() && SemiColon.isSemiColon(tokens.getToken()),
				";");
		tokens.skip();
	}

	public static void print() {
		System.out.println(";");
	}

}

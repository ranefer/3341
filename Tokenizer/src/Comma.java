public class Comma implements Terminal {

	public static boolean isComma(int token) {
		return token == 13;
	}

	public static void parse(Tokens symbols) {
		Reporter.Assert(symbols.hasCurrent() && isComma(symbols.getToken()),
				";");
		symbols.skip();
	}

	public static void print() {
		System.out.print(", ");
	}

}

public class End implements Terminal {

	public static boolean isEnd(int token) {
		return token == 3;
	}

	public static void print(int tabStop) {
		Tab.print(tabStop);
		System.out.print("end");
	}

	public static void parse(Tokens tokens) {
		Reporter.Assert(tokens.hasCurrent() && End.isEnd(tokens.getToken()),
				"end");
		tokens.skip();
	}

}

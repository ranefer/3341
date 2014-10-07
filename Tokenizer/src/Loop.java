public class Loop {

	public static boolean isLoop(String token) {
		return token.equals("while");
	}

	public static void parse(Symbol symbols) {
		Reporter.Assert(symbols.hasCurrent() && isLoop(symbols.current()),
				"while");
		Tokens.add(8);
		symbols.skip();

		Condition.parse(symbols);

		Reporter.Assert(symbols.hasCurrent()
				&& symbols.current().equals("loop"), "loop");
		Tokens.add(9);
		symbols.skip();

		Statement.parse(symbols);
		End.parse(symbols);
		Colon.parse(symbols);
	}
}

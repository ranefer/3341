public class Loop {

	public static boolean isLoop(int token) {
		return token == 9;
	}

	public static void parse(Tokens tokens) {
		Reporter.Assert(tokens.hasCurrent() && isLoop(tokens.getToken()),
				"while");
		tokens.skip();

		Condition.parse(tokens);

		Reporter.Assert(tokens.hasCurrent()
				&& Loop.isLoop(tokens.getToken()), "loop");
		tokens.skip();

		Statement.parse(tokens);
		End.parse(tokens);
		Colon.parse(tokens);
	}
}

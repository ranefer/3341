public class If {

	public static boolean isIf(int token) {
		return token == 5;
	}

	public static void parse(Tokens tokens) {
		Reporter.Assert(isIf(tokens.getToken()), "if");
		tokens.skip();

		Condition.parse(tokens);

		Reporter.Assert(tokens.hasCurrent()
				&& tokens.getToken()==6, "then");
		tokens.skip();

		Statement.parse(tokens);

		parseElse(tokens);

		End.parse(tokens);

		Colon.parse(tokens);
	}

	private static void parseElse(Tokens tokens) {
		if (tokens.hasCurrent()) {
			if (tokens.getToken() == 7) {
				tokens.skip();
				if (Statement.isStatement(tokens.getToken()))
					Statement.parse(tokens);
			}
		}
	}
}

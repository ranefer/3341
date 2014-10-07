public class If {

	public static boolean isIf(String token) {
		return token.equals("if");
	}

	public static void parse(Symbol symbols) {
		Reporter.Assert(isIf(symbols.current()), "if");
		Tokens.add(5);
		symbols.skip();

		Condition.parse(symbols);

		Reporter.Assert(symbols.hasCurrent()
				&& symbols.current().equals("then"), "then");
		Tokens.add(6);
		symbols.skip();

		Statement.parse(symbols);

		parseElse(symbols);

		End.parse(symbols);

		Colon.parse(symbols);
	}

	private static void parseElse(Symbol symbols) {
		if (symbols.hasNext()) {
			if (symbols.current().equals("else")) {
				Tokens.add(7);
				symbols.next();
				if (Statement.isStatement(symbols.current()))
					Statement.parse(symbols);
			}
		}
	}
}

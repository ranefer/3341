import java.util.ArrayList;

public class If {

	public static boolean isIf(String token) {
		return token.equals("if");
	}

	public static void parse(Token tokens) {
		Reporter.Assert(isIf(tokens.current()), "Expected If but was " + tokens.current());
		tokens.skip();

		Condition.parse(tokens);

		Reporter.Assert(tokens.current().equals("then"), "Expected 'then' but was " + tokens.current());
		tokens.skip();

		Statement.parse(tokens);

		parseElse(tokens);

		Reporter.Assert(tokens.current().equals("end"), "Expected 'end' but was " + tokens.current());
		tokens.skip();
		
		Colon.parse(tokens);
	}

	public static void parseCondition(Token tokens) {
		String openParen = tokens.current();
		Reporter.Assert(openParen.equals("("), "Expected: '(' but was "
				+ openParen);

		Condition.parse(tokens);

		String closedParen = tokens.current();
		Reporter.Assert(closedParen.equals(")"), "Expected: ')' but was,"
				+ closedParen);

		tokens.skip();
	}

	private static void parseElse(Token tokens) {
		if (tokens.hasNext()) {
			if (tokens.current().equals("else")) {
				tokens.next();
				if (Statement.isStatement(tokens.current()))
					Statement.parse(tokens);
			}
		}
	}
}

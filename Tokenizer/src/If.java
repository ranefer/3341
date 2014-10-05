import java.util.ArrayList;

public class If {

	public static boolean isIf(String token) {
		return token.equals("if");
	}

	public static void parse(Token tokens, ArrayList<Integer> t) {
		Reporter.Assert(tokens.hasCurrent() && isIf(tokens.current()), "Expected If");
		tokens.skip();

		Condition.parse(tokens, t);

		Reporter.Assert(tokens.hasCurrent() && tokens.current().equals("then"), "Expected 'then',");
		tokens.skip();

		Statement.parse(tokens, t);

		parseElse(tokens, t);

		End.parse(tokens, t);
		
		Colon.parse(tokens, t);
	}

	public static void parseCondition(Token tokens, ArrayList<Integer> t) {
		String openParen = tokens.current();
		Reporter.Assert(tokens.hasCurrent() && openParen.equals("("), "Expected: '(' but was "
				+ openParen);

		Condition.parse(tokens, t);

		String closedParen = tokens.current();
		Reporter.Assert(tokens.hasCurrent() && closedParen.equals(")"), "Expected: ')' but was,"
				+ closedParen);

		tokens.skip();
	}

	private static void parseElse(Token tokens, ArrayList<Integer> t) {
		if (tokens.hasCurrent()) {
			if (tokens.current().equals("else")) {
				tokens.next();
				if (Statement.isStatement(tokens.current()))
					Statement.parse(tokens, t);
			}
		}
	}
}

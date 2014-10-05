import java.util.ArrayList;

public class If {

	public static boolean isIf(String token) {
		return token.equals("if");
	}

	public static void parse(Symbol symbols) {
		Reporter.Assert(isIf(symbols.current()), "if");
		symbols.skip();

		Condition.parse(symbols);

		Reporter.Assert(symbols.hasCurrent() && symbols.current().equals("then"), "then");
		symbols.skip();

		Statement.parse(symbols);

		parseElse(symbols);

		End.parse(symbols);
		
		Colon.parse(symbols);
	}

	public static void parseCondition(Symbol tokens) {
		String openParen = tokens.current();
		Reporter.Assert(openParen.equals("("), "(");

		Condition.parse(tokens);

		String closedParen = tokens.current();
		Reporter.Assert(closedParen.equals(")"), ")");

		tokens.skip();
	}

	private static void parseElse(Symbol tokens) {
		if (tokens.hasNext()) {
			if (tokens.current().equals("else")) {
				tokens.next();
				if (Statement.isStatement(tokens.current()))
					Statement.parse(tokens);
			}
		}
	}
}

import java.util.ArrayList;

public class If {
	
	public static boolean isIf(String token) {
		return token.equals("if");
	}

	public static void parse(Token tokens, ArrayList<Integer> t) {
		assert (isIf(tokens.current()));
		tokens.skip();

		Condition.parse(tokens, t);

		assert(tokens.current().equals("then")): "Expected 'then'";
		tokens.skip();

		Statement.parse(tokens, t);

		parseElse(tokens, t);
		
		assert(tokens.current().equals("end")) : "Expected 'end'";
		tokens.skip();
	}

	public static void parseCondition(Token tokens, ArrayList<Integer> t) {
		String openParen = tokens.current();
		assert (openParen.equals("(")) : "Expected: '(' but was " + openParen;

		Condition.parse(tokens, t);

		String closedParen = tokens.current();
		assert (closedParen.equals(")")) : "Expected: ')' but was "
				+ closedParen;

		tokens.skip();
	}

	private static void parseElse(Token tokens, ArrayList<Integer> t) {
		if (tokens.hasNext()) {
			if (tokens.current().equals("else")) {
				tokens.next();
				if (Statement.isStatement(tokens.current()))
					Statement.parse(tokens, t);
			}
		}
	}
}

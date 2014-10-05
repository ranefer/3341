import java.util.ArrayList;

public class Comparison {

	public static boolean isComparison(String token) {
		return token.equals("(");
	}

	public static void parse(Token tokens) {
		Reporter.Assert(isComparison(tokens.current()), "Expected Comparison but was " + tokens.current());

		parseOpenParen(tokens);

		Op.parse(tokens);

		parseCompareOperator(tokens);

		Op.parse(tokens);

		parseClosedParen(tokens);
	}

	private static void parseOpenParen(Token tokens) {
		Reporter.Assert(tokens.current().equals("("), "Expected '(' but was " + tokens.current());
		Tokenizer.result.add(20); // (

		tokens.skip();
	}

	private static void parseClosedParen(Token tokens) {
		Reporter.Assert(tokens.current().equals(")"), "Expected ')' but was " + tokens.current());
		Tokenizer.result.add(21); // )

		tokens.skip();
	}

	private static void parseCompareOperator(Token tokens) {
		if (tokens.hasNext()) {
			switch (tokens.current()) {
			case "!=":
				Tokenizer.result.add(25);
				break;
			case "==":
				Tokenizer.result.add(26);
				break;
			case "<":
				Tokenizer.result.add(27);
				break;
			case ">":
				Tokenizer.result.add(28);
				break;
			case "<=":
				Tokenizer.result.add(29);
				break;
			case ">=":
				Tokenizer.result.add(30);
				break;
			default:
				Reporter.Assert(false, "Exptected a comparision but was "
						+ tokens.current());
			}
		} else
			Reporter.Assert(false,
					"Exptected a comparision but was " + tokens.current());

		tokens.skip();
	}
}

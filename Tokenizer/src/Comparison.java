import java.util.ArrayList;

public class Comparison {

	public static boolean isComparison(String token) {
		return token.equals("(");
	}

	public static void parse(Symbol symbols) {
		Reporter.Assert(symbols.hasCurrent() && isComparison(symbols.current()), "(");

		parseOpenParen(symbols);

		Op.parse(symbols);

		parseCompareOperator(symbols);

		Op.parse(symbols);

		parseClosedParen(symbols);
	}

	private static void parseOpenParen(Symbol symbols) {
		Reporter.Assert(symbols.hasCurrent() && symbols.current().equals("("), "(");
		Tokens.add(20); // (

		symbols.skip();
	}

	private static void parseClosedParen(Symbol symbols) {
		Reporter.Assert(symbols.hasCurrent() && symbols.current().equals(")"), ")");
		Tokens.add(21); // )

		symbols.skip();
	}

	private static void parseCompareOperator(Symbol symbols) {
		if (symbols.hasNext()) {
			switch (symbols.current()) {
			case "!=":
				Tokens.add(25);
				break;
			case "==":
				Tokens.add(26);
				break;
			case "<":
				Tokens.add(27);
				break;
			case ">":
				Tokens.add(28);
				break;
			case "<=":
				Tokens.add(29);
				break;
			case ">=":
				Tokens.add(30);
				break;
			default:
				Reporter.Assert(false, "comparision");
			}
		} else
			Reporter.Assert(false,
					"comparision");

		symbols.skip();
	}
}

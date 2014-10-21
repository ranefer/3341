import java.util.ArrayList;

public class Comparison {

	public static boolean isComparison(int token) {
		return token == 20; // (
	}

	public static void parse(Tokens symbols) {
		Reporter.Assert(symbols.hasCurrent() && isComparison(symbols.getToken()), "(");

		parseOpenParen(symbols);

		Op.parse(symbols);

		parseCompareOperator(symbols);

		Op.parse(symbols);

		parseClosedParen(symbols);
	}

	private static void parseOpenParen(Tokens symbols) {
		Reporter.Assert(symbols.hasCurrent() && symbols.getToken()==20, "(");
		symbols.skip();
	}

	private static void parseClosedParen(Tokens symbols) {
		Reporter.Assert(symbols.hasCurrent() && symbols.getToken()==21, ")");
		symbols.skip();
	}

	private static void parseCompareOperator(Tokens symbols) {
		if (symbols.hasCurrent()) {
			switch (symbols.getToken()) {
			case 25: // !=
				break;
			case 26: // ==
				break;
			case 27: // <
				break;
			case 28: // >
				break;
			case 29: // <=
				break;
			case 30: // >=
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

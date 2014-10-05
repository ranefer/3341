import java.util.ArrayList;

public class Condition {

	public static boolean isCondition(String token) {
		boolean result = false;
		result = result || token.equals("!");
		result = result || token.equals("[");
		result = result || Comparison.isComparison(token);
		return result;
	}

	public static void parse(Symbol symbols) {
		Reporter.Assert(symbols.hasCurrent() && isCondition(symbols.current()), "Condition");

		String alternative = symbols.current();

		if (Comparison.isComparison(alternative)) {
			Comparison.parse(symbols);
		} else if (alternative.equals("!")) {
			parseExclamationPoint(symbols);
			Condition.parse(symbols);
		} else if (alternative.equals("[")) {
			parseOpenBracket(symbols);
			Condition.parse(symbols);
			parseSymbol(symbols);
			Condition.parse(symbols);
			parseClosedBracket(symbols);
		}
	}

	public static void parseExclamationPoint(Symbol symbols) {
		Reporter.Assert(symbols.hasCurrent() && symbols.current().equals("!"), "!");
		Tokens.add(15); // !

		symbols.skip();
	}

	public static void parseOpenBracket(Symbol symbols) {
		Reporter.Assert(symbols.hasCurrent() && symbols.current().equals("["), "[");
		Tokens.add(16);

		symbols.skip();
	}

	public static void parseClosedBracket(Symbol symbols) {
		Reporter.Assert(symbols.hasCurrent() && symbols.current().equals("]"), "]");
		Tokens.add(17);

		symbols.skip();
	}

	public static void parseSymbol(Symbol symbols) {
		if (symbols.current().equals("&&"))
			Tokens.add(18); // &&
		else if (symbols.current().equals("||"))// 18
			Tokens.add(19); // ||
		else
			Reporter.Assert(symbols.hasCurrent() && false, "'&&' or '||'");

		symbols.skip();
	}
}

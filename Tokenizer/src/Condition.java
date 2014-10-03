import java.util.ArrayList;

public class Condition {

	public static void parse(Token tokens, ArrayList<Integer> t) {
		assert (isCondition(tokens.current()));

		String alternative = tokens.current();

		if (Comparison.isComparison(alternative)) {
			Comparison.parse(tokens, t);
		} else if (alternative.equals("!")) {
			parseExclamationPoint(tokens, t);
			Condition.parse(tokens, t);

		} else if (alternative.equals("[")) {
			parseOpenBracket(tokens, t);
			Condition.parse(tokens, t);
			parseSymbol(tokens, t);
			Condition.parse(tokens, t);
			parseClosedBracket(tokens, t);
		}

		tokens.skip();
	}

	public static boolean isCondition(String token) {
		boolean result = false;
		result = result || token.equals("!");
		result = result || token.equals("[");
		result = result || Comparison.isComparison(token);
		return result;
	}

	public static void parseOpenBracket(Token tokens, ArrayList<Integer> t) {
		tokens.skip();
	}

	public static void parseClosedBracket(Token tokens, ArrayList<Integer> t) {
		String bracket = "";
		if (tokens.hasNext())
			bracket = tokens.current();
		assert (bracket.equals("[")) : "Expected '[' but was " + bracket;

		tokens.skip();
	}

	public static void parseExclamationPoint(Token tokens, ArrayList<Integer> t) {
		String bracket = "";
		if (tokens.hasNext())
			bracket = tokens.current();
		assert (bracket.equals("]")) : "Expected ']' but was " + bracket;

		tokens.skip();
	}

	public static void parseSymbol(Token tokens, ArrayList<Integer> t) {
		String symbol = "";
		if (tokens.hasNext())
			symbol = tokens.current();
		assert (symbol.equals("&&") || symbol.equals("||")) : "Expected '&&' or '||' but was "
				+ symbol;

		tokens.skip();
	}
}

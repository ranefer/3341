import java.util.ArrayList;

public class Condition {

	public static boolean isCondition(String token) {
		boolean result = false;
		result = result || token.equals("!");
		result = result || token.equals("[");
		result = result || Comparison.isComparison(token);
		return result;
	}

	public static void parse(Token tokens, ArrayList<Integer> t) {
		Reporter.Assert(isCondition(tokens.current()), "Expected Condition");

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
	}

	public static void parseExclamationPoint(Token tokens, ArrayList<Integer> t) {
		Reporter.Assert(tokens.current().equals("!"), "Expected '!'");
		t.add(15); // !

		tokens.skip();
	}

	public static void parseOpenBracket(Token tokens, ArrayList<Integer> t) {
		Reporter.Assert(tokens.current().equals("["), "Expected '['");
		t.add(16);

		tokens.skip();
	}

	public static void parseClosedBracket(Token tokens, ArrayList<Integer> t) {
		Reporter.Assert(tokens.current().equals("]"), "Expected ']'");
		t.add(17);

		tokens.skip();
	}

	public static void parseSymbol(Token tokens, ArrayList<Integer> t) {
		if (tokens.current().equals("&&"))
			t.add(18); // &&
		else if (tokens.current().equals("||"))// 18
			t.add(19); // ||
		else
			Reporter.Assert(false, "Expected '&&' or '||'");

		tokens.skip();
	}
}

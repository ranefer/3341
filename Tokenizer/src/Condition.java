import java.util.ArrayList;

public class Condition {

	public static boolean isCondition(String token) {
		boolean result = false;
		result = result || token.equals("!");
		result = result || token.equals("[");
		result = result || Comparison.isComparison(token);
		return result;
	}

	public static void parse(Token tokens) {
		Reporter.Assert(isCondition(tokens.current()), "Expected Condition");

		String alternative = tokens.current();

		if (Comparison.isComparison(alternative)) {
			Comparison.parse(tokens);
		} else if (alternative.equals("!")) {
			parseExclamationPoint(tokens);
			Condition.parse(tokens);
		} else if (alternative.equals("[")) {
			parseOpenBracket(tokens);
			Condition.parse(tokens);
			parseSymbol(tokens);
			Condition.parse(tokens);
			parseClosedBracket(tokens);
		}
	}

	public static void parseExclamationPoint(Token tokens) {
		Reporter.Assert(tokens.current().equals("!"), "Expected '!'");
		Tokenizer.result.add(15); // !

		tokens.skip();
	}

	public static void parseOpenBracket(Token tokens) {
		Reporter.Assert(tokens.current().equals("["), "Expected '['");
		Tokenizer.result.add(16);

		tokens.skip();
	}

	public static void parseClosedBracket(Token tokens) {
		Reporter.Assert(tokens.current().equals("]"), "Expected ']'");
		Tokenizer.result.add(17);

		tokens.skip();
	}

	public static void parseSymbol(Token tokens) {
		if (tokens.current().equals("&&"))
			Tokenizer.result.add(18); // &&
		else if (tokens.current().equals("||"))// 18
			Tokenizer.result.add(19); // ||
		else
			Reporter.Assert(false, "Expected '&&' or '||'");

		tokens.skip();
	}
}

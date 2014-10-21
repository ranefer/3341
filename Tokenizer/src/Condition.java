import java.util.ArrayList;

public class Condition {

	public static boolean isCondition(int token) {
		boolean result = false;
		result = result || token == 15; // !
		result = result || token == 16; // [
		result = result || Comparison.isComparison(token);
		return result;
	}

	public static void parse(Tokens tokens) {
		Reporter.Assert(tokens.hasCurrent() && isCondition(tokens.getToken()), "Condition");

		int alternative = tokens.getToken();

		if (Comparison.isComparison(alternative)) {
			Comparison.parse(tokens);
		} else if (alternative == 15) {
			parseExclamationPoint(tokens);
			Condition.parse(tokens);
		} else if (alternative == 16) {
			parseOpenBracket(tokens);
			Condition.parse(tokens);
			parseTokens(tokens);
			Condition.parse(tokens);
			parseClosedBracket(tokens);
		}
	}

	public static void parseExclamationPoint(Tokens tokens) {
		Reporter.Assert(tokens.hasCurrent() && tokens.getToken()==15, "!");
		tokens.skip();
	}

	public static void parseOpenBracket(Tokens tokens) {
		Reporter.Assert(tokens.hasCurrent() && tokens.getToken()==16, "[");
		tokens.skip();
	}

	public static void parseClosedBracket(Tokens tokens) {
		Reporter.Assert(tokens.hasCurrent() && tokens.getToken()==17, "]");
		tokens.skip();
	}

	public static void parseTokens(Tokens tokens) {
		if (tokens.getToken()==18 || tokens.getToken()==19)// && --OR-- ||
            tokens.skip();
		else
			Reporter.Assert(tokens.hasCurrent() && false, "'&&' or '||'");
	}
}

public class Condition implements Production {

	Production p;
	Production p2;

	char[] extraSymbols;

	public Condition() {
		extraSymbols = new char[3];
	}

	public static boolean isCondition(int token) {
		boolean result = false;
		result = result || token == 15; // !
		result = result || token == 16; // [
		result = result || Comparison.isComparison(token);
		return result;
	}

	public void parse(Tokens tokens) {
		Reporter.Assert(tokens.hasCurrent() && isCondition(tokens.getToken()),
				"Condition");

		int alternative = tokens.getToken();

		if (Comparison.isComparison(alternative)) {
			p = new Comparison();
			p.parse(tokens);
		} else if (alternative == 15) {
			parseExclamationPoint(tokens);
			p.parse(tokens);
		} else if (alternative == 16) {
			parseOpenBracket(tokens);
			p.parse(tokens);
			parseTokens(tokens);
			p2.parse(tokens);
			parseClosedBracket(tokens);
		}
	}

	public void parseExclamationPoint(Tokens tokens) {
		Reporter.Assert(tokens.hasCurrent() && tokens.getToken() == 15, "!");
		extraSymbols[0] = '!';
		tokens.skip();
	}

	public void parseOpenBracket(Tokens tokens) {
		Reporter.Assert(tokens.hasCurrent() && tokens.getToken() == 16, "[");
		extraSymbols[0] = '[';
		tokens.skip();
	}

	public void parseClosedBracket(Tokens tokens) {
		Reporter.Assert(tokens.hasCurrent() && tokens.getToken() == 17, "]");
		extraSymbols[2] = ']';
		tokens.skip();
	}

	public void parseTokens(Tokens tokens) {
		if (tokens.getToken() == 18)// && --OR-- ||
			extraSymbols[1] = '&';
		else if (tokens.getToken() == 19)
			extraSymbols[1] = '|';
		else
			Reporter.Assert(tokens.hasCurrent() && false, "'&&' or '||'");

		tokens.skip();
	}

	public void execute() {

	}

	public void print() {
		if (p2 != null) {
			System.out.println(extraSymbols[0]);
			p.print();
			System.out.println(extraSymbols[1]);
			System.out.println(extraSymbols[1]);
			p2.print();
			System.out.println(extraSymbols[2]);
		} else
			p.print();
	}
}

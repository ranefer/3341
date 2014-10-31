public class Condition implements BooleanProduction {

	BooleanProduction p;
	BooleanProduction p2;

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
			p = new Condition();
			p.parse(tokens);
		} else if (alternative == 16) {
			parseOpenBracket(tokens);
			p = new Condition();
			p2 = new Condition();
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

	public boolean evaluate() {
        boolean result = p.evaluate();
        if (extraSymbols[0]== '!')
        	return !p.evaluate();
		else if(extraSymbols[0] == '[' && extraSymbols[1] == '&')
			return p.evaluate() && p2.evaluate();
		else if(extraSymbols[0] == '[' && extraSymbols[1] == '|')
			return p.evaluate() || p2.evaluate();
        return result;
	}

	public void print(int tabStop) {
		if (p2 != null) {
			System.out.print(extraSymbols[0]);
			p.print(tabStop);
			System.out.print(extraSymbols[1]);
			System.out.print(extraSymbols[1]);
			p2.print(tabStop);
			System.out.print(extraSymbols[2]);
		} else
			p.print(tabStop);
	}
}

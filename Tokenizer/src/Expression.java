public class Expression implements Production {

	Production factor;
	String symbol;
	Production expression;

	public Expression() {
		factor = new Factor();
	}

	public static boolean isExpression(int token) {
		return Factor.isFactor(token);
	}

	public void parse(Tokens tokens) {
		expression = new Expression();
		Reporter.Assert(tokens.hasCurrent() && isExpression(tokens.getToken()),
				"Expression");

		factor.parse(tokens);

		if (tokens.hasCurrent() && tokens.getToken() == 22) {
			symbol = "+";
			tokens.skip();
			expression.parse(tokens);
		} else if (tokens.hasCurrent() && tokens.getToken() == 23) {
			symbol = "-";
			tokens.skip();
			expression.parse(tokens);
		}
	}

	public void execute() {

	}

	public void print(int tabStop) {
		factor.print(tabStop);
		if (expression != null)
			expression.print(tabStop);
	}

}

public class Expression implements Production {

	Production factor;
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
			expression.parse(tokens);
		} else if (tokens.hasCurrent() && tokens.getToken() == 23) {
			expression.parse(tokens);
		}
	}

	public void execute() {

	}

	public void print() {
		factor.print();
		if (expression != null)
			expression.print();
	}

}

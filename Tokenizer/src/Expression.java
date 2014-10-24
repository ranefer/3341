public class Expression implements NumericProduction {

	Factor factor;
	String symbol;
	Expression expression;

	public Expression() {
		factor = new Factor();
	}

	public static boolean isExpression(int token) {
		return Factor.isFactor(token);
	}

	public void parse(Tokens tokens) {
		Reporter.Assert(tokens.hasCurrent() && isExpression(tokens.getToken()),
				"Expression");

		factor.parse(tokens);

		if (tokens.hasCurrent() && tokens.getToken() == 22) {
            expression = new Expression();
			symbol = "+";
			tokens.skip();
			expression.parse(tokens);
		} else if (tokens.hasCurrent() && tokens.getToken() == 23) {
            expression = new Expression();
			symbol = "-";
			tokens.skip();
			expression.parse(tokens);
		}
	}

	public int value() {
		int result = factor.value();
		if(symbol == "+") {
			result += expression.value();
		}else if(symbol == "-"){
			result -= expression.value();
		}
		return result;
	}

	public void print(int tabStop) {
		factor.print(tabStop);
		if (expression != null){ 
			System.out.print(" " + symbol + " ");
			expression.print(tabStop);
		}
	}

}

import java.util.ArrayList;

public class Expression {

	public static boolean isExpression(String token) {
		return Factor.isFactor(token);
	}

	public static void parse(Symbol tokens) {
		Reporter.Assert(tokens.hasCurrent() && isExpression(tokens.current()), "Expression");

		Factor.parse(tokens);

		if (tokens.hasCurrent() && tokens.current().equals("+")) {
			Tokens.add(22);
			Expression.parse(tokens);
		} else if (tokens.hasCurrent() && tokens.current().equals("-")) {
			Tokens.add(23);
			Expression.parse(tokens);
		}
	}
}

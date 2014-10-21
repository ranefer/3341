import java.util.ArrayList;

public class Expression {

	public static boolean isExpression(int token) {
		return Factor.isFactor(token);
	}

	public static void parse(Tokens tokens) {
		Reporter.Assert(tokens.hasCurrent() && isExpression(tokens.getToken()), "Expression");

		Factor.parse(tokens);

		if (tokens.hasCurrent() && tokens.getToken() == 22) {
			Expression.parse(tokens);
		} else if (tokens.hasCurrent() && tokens.getToken() == 23) {
			Expression.parse(tokens);
		}
	}
}

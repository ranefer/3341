import java.util.ArrayList;

public class Expression {

	public static boolean isExpression(String token) {
		return Factor.isFactor(token);
	}

	public static void parse(Token tokens, ArrayList<Integer> t) {
		Reporter.Assert(tokens.hasCurrent() && isExpression(tokens.current()), "Expected Expression");

		Factor.parse(tokens, t);

		if (tokens.hasCurrent() && tokens.current().equals("+")) {
			t.add(22);
			Expression.parse(tokens, t);
		} else if (tokens.hasCurrent() && tokens.current().equals("-")) {
			t.add(23);
			Expression.parse(tokens, t);
		}
	}
}

import java.util.ArrayList;

public class Expression {

	public static boolean isExpression(String token) {
		return Factor.isFactor(token);
	}

	public static void parse(Token tokens) {
		Reporter.Assert(isExpression(tokens.current()), "Expected Expression");

		Factor.parse(tokens);

		if (tokens.hasCurrent() && tokens.current().equals("+")) {
			Tokenizer.result.add(22);
			Expression.parse(tokens);
		} else if (tokens.hasCurrent() && tokens.current().equals("-")) {
			Tokenizer.result.add(23);
			Expression.parse(tokens);
		}
	}
}

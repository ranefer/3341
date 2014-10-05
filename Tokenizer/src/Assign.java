import java.util.ArrayList;

public class Assign {

	public static boolean isAssign(String token) {
		return Id.isId(token); // assign { id = expression }
	}

	public static void parse(Token tokens) {
		Reporter.Assert(isAssign(tokens.current()), "Expected Id but was " + tokens.current());
		Id.parse(tokens);

		parseEqualSign(tokens);

		Expression.parse(tokens);

		Colon.parse(tokens);
	}

	public static void parseEqualSign(Token tokens) {
		Reporter.Assert(tokens.current().equals("="), "Expected '=' but was "
				+ tokens.current());
		Tokenizer.result.add(14);
		tokens.skip();
	}
}

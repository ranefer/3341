import java.util.ArrayList;

public class Assign {

	public static boolean isAssign(int token) {
		return Id.isId(token); // assign { id = expression }
	}

	public static void parse(Tokens tokens) {
		Reporter.Assert(tokens.hasCurrent() && isAssign(tokens.getToken()), "Id");
		Id.parse(tokens);

		parseEqualSign(tokens);

		Expression.parse(tokens);

		Colon.parse(tokens);
	}

	public static void parseEqualSign(Tokens tokens) {
		Reporter.Assert(tokens.hasCurrent() && tokens.getToken()==14, "=");
		tokens.skip();
	}
}

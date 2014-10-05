import java.util.ArrayList;

public class Assign {

	public static boolean isAssign(String token) {
		return Id.isId(token); // assign { id = expression }
	}

	public static void parse(Token tokens, ArrayList<Integer> t) {
		Reporter.Assert(tokens.hasCurrent() && isAssign(tokens.current()), "Expected Id");
		Id.parse(tokens, t);

		parseEqualSign(tokens, t);

		Expression.parse(tokens, t);

		Colon.parse(tokens, t);
	}

	public static void parseEqualSign(Token tokens, ArrayList<Integer> t) {
		Reporter.Assert(tokens.hasCurrent() && tokens.current().equals("="), "Expected '=' but was "
				+ tokens.current());
		t.add(14);
		tokens.skip();
	}
}

import java.util.ArrayList;

public class Id {

	public static boolean isId(String token) {
		return token.matches("[A-Z]+[0-9]*");
	}

	public static void parse(Token tokens, ArrayList<Integer> t) {
		Reporter.Assert(tokens.hasCurrent() && isId(tokens.current()), "Expected Id");
		t.add(32); // id
		tokens.skip();

		if (tokens.hasCurrent() && Comma.isComma(tokens.current())) {
			Comma.parse(tokens, t);
			Id.parse(tokens, t);
		}
	}
}

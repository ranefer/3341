import java.util.ArrayList;

public class Input {

	public static boolean isInput(String token) {
		return token.equals("read");
	}

	public static void parse(Token tokens, ArrayList<Integer> t) {
		Reporter.Assert(isInput(tokens.current()), "Expected Input");
		t.add(10);
		tokens.skip();

		Id.parse(tokens, t);
		Colon.parse(tokens, t);
	}
}

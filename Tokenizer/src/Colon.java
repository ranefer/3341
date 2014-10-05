import java.util.ArrayList;

public class Colon {

	public static boolean isColon(String token) {
		return token.equals(";");
	}

	public static void parse(Token tokens, ArrayList<Integer> t) {
		Reporter.Assert(isColon(tokens.current()), "Expected ';'");
		t.add(12);
		tokens.skip();
	}
}

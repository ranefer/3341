import java.util.ArrayList;

public class Assign {

	public static void parse(Token tokens, ArrayList<Integer> t) {
		assert (isAssign(tokens.current()));

	}

	public static boolean isAssign(String token) {
		// TODO
		return false;
	}

	private static void parseColon(Token tokens, ArrayList<Integer> t) {

		String semiColon = "";
		if (tokens.hasNext())
			semiColon = tokens.current();
		assert (semiColon.equals(";")) : "Expected: ';' but was " + semiColon;

		t.add(12); // ;

		tokens.skip();
	}
}

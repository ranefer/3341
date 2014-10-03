import java.util.ArrayList;

public class Statement {
	private static final String[] RESERVED = { "if", "while", "loop", "assign",
			"read", "write" };

	public static void parse(Token tokens, ArrayList<Integer> t) {
		assert (isStatement(tokens.current()));

	}

	public static boolean isStatement(String token) {
		boolean result = false;
		for (String s : RESERVED) {
			result = result || token.equals(s);
		}
		return result;
	}
}

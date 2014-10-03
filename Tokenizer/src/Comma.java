import java.util.ArrayList;

public class Comma {

	public static boolean isComma(String token) {
		return token.equals(",");
	}
	
	public static void parse(Token tokens, ArrayList<Integer> t) {
		assert(isComma(tokens.current()));
		t.add(13);
		tokens.skip();
	}
}

import java.util.ArrayList;

public class Input {

	public static boolean isInput(String token) {
		return token.equals("read");
	}

	public static void parse(Token tokens, ArrayList<Integer> t) {
		assert(isInput(tokens.current()));
		t.add(10);
		tokens.skip();
		
		Id.parse(tokens, t);
		Colon.parse(tokens, t);
	}

}

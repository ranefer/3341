import java.util.ArrayList;

public class Input {

	public static boolean isInput(String token) {
		return token.equals("read");
	}

	public static void parse(Token tokens, ArrayList<Integer> t) {
		assert(isInput(tokens.current()));
		t.add(10);
		tokens.skip();
		
		assert(tokens.hasCurrent() && Id.isId(tokens.current())) : "Expected id";
		Id.parse(tokens, t);
		
		assert(tokens.hasCurrent() && Colon.isColon(tokens.current())) : "Expected ';'";
		Colon.parse(tokens, t);
	}

}

import java.util.ArrayList;

public class Output {

	public static boolean isOutput (String token) {
		return token.equals("write");
	}

	public static void parse(Token tokens, ArrayList<Integer> t) {
		assert(isOutput(tokens.current()));
		t.add(11);
		tokens.skip();
		
		Id.parse(tokens, t);
		Colon.parse(tokens, t);
	}
}

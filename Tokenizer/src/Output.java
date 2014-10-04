import java.util.ArrayList;

public class Output {

	public static boolean isOutput (String token) {
		return token.equals("write");
	}

	public static void parse(Token tokens, ArrayList<Integer> t) {
		assert(isOutput(tokens.current()));
		t.add(11);
		tokens.skip();
		
		assert(tokens.hasCurrent() && Id.isId(tokens.current())) : "Expected id";
		Id.parse(tokens, t);
		
		assert(tokens.hasCurrent() && Colon.isColon(tokens.current())) : "Expected ';'";
		Colon.parse(tokens, t);
	}
}

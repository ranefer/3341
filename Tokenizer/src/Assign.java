import java.util.ArrayList;

public class Assign {


	public static boolean isAssign(String token) {
		return Id.isId(token); // assign { id = expression }
	}
	public static void parse(Token tokens, ArrayList<Integer> t) {
		assert (isAssign(tokens.current()));
		Id.parse(tokens, t);
		
        parseEqualSign(tokens, t);
		
		Expression.parse(tokens, t);
		
		Colon.parse(tokens, t);
	}
	
	public static void parseEqualSign(Token tokens, ArrayList<Integer> t) {
		assert(tokens.current().equals("=")) : "Expected '=' but was " + tokens.current();
		t.add(14);
		tokens.skip();
	}
}

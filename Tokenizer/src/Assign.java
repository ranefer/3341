import java.util.ArrayList;

public class Assign {


	public static boolean isAssign(String token) {
		return Id.isId(token); // assign { id = expression }
	}
	public static void parse(Token tokens, ArrayList<Integer> t) {
		assert (isAssign(tokens.current()));
		Id.parse(tokens, t);
		
		assert(tokens.hasCurrent()) : "Expected '='";
        parseEqualSign(tokens, t);
		
		assert(tokens.hasCurrent() && Expression.isExpression(tokens.current())) : "Expected expression";
		Expression.parse(tokens, t);
		
		assert(tokens.hasCurrent() && Colon.isColon(tokens.current())) : "Expected ';'";
		Colon.parse(tokens, t);
	}
	
	public static void parseEqualSign(Token tokens, ArrayList<Integer> t) {
		assert(tokens.current().equals("=")) : "Expected '=' but was " + tokens.current();
		t.add(13);
		tokens.skip();
	}
}

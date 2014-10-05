import java.util.ArrayList;

public class Loop {

	public static boolean isLoop (String token) {
		return token.equals("while");
	}
	
	public static void parse(Token tokens, ArrayList<Integer> t) {
		assert(isLoop(tokens.current()));
		tokens.skip();
	
		Condition.parse(tokens, t);
		
		assert(tokens.current().equals("loop")) : "Expected 'loop'";
		tokens.skip();
		
		Statement.parse(tokens, t);
		
		assert(tokens.current().equals("end")): "Expected 'end'";
		tokens.skip();
	}
}

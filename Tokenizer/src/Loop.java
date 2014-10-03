import java.util.ArrayList;

public class Loop {

	public static boolean isLoop (String token) {
		return token.equals("while");
	}
	
	public static void parse(Token tokens, ArrayList<Integer> t) {
		assert(isLoop(tokens.current()));
		tokens.skip();
	
		assert(tokens.hasCurrent() && Condition.isCondition(tokens.current())) : "Expected condition";
		Condition.parse(tokens, t);
		
		assert(tokens.hasCurrent() && tokens.current().equals("loop")) : "Expected 'loop'";
		tokens.skip();
		
		assert(tokens.hasCurrent() && Statement.isStatement(tokens.current())) : "Expected statement";
		Statement.parse(tokens, t);
		
		assert(tokens.hasCurrent() && tokens.current().equals("end")): "Expected 'end'";
	}
}

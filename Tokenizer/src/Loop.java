import java.util.ArrayList;

public class Loop {

	public static boolean isLoop(String token) {
		return token.equals("while");
	}

	public static void parse(Token tokens, ArrayList<Integer> t) {
		Reporter.Assert(tokens.hasCurrent() && isLoop(tokens.current()), "Expected Loop");
		tokens.skip();

		Condition.parse(tokens, t);

		Reporter.Assert(tokens.hasCurrent() && tokens.current().equals("loop"), "Expected 'loop',");
		tokens.skip();

		Statement.parse(tokens, t);

		End.parse(tokens, t);
		
		Colon.parse(tokens, t);
	}
}

import java.util.ArrayList;

public class Loop {

	public static boolean isLoop(String token) {
		return token.equals("while");
	}

	public static void parse(Token tokens) {
		Reporter.Assert(isLoop(tokens.current()), "Expected Loop but was " + tokens.current());
		tokens.skip();

		Condition.parse(tokens);

		Reporter.Assert(tokens.current().equals("loop"), "Expected 'loop' but was " + tokens.current());
		tokens.skip();

		Statement.parse(tokens);

		Reporter.Assert(tokens.current().equals("end"), "Expected 'end' but was " + tokens.current());
		tokens.skip();
		
		Colon.parse(tokens);
	}
}

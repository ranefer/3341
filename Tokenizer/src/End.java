import java.util.ArrayList;

public class End {
	
	public static boolean isEnd(String token) {
		return token.equals("end");
	}
	
	public static void parse(Token tokens, ArrayList<Integer> t) {
		Reporter.Assert(tokens.hasCurrent() && tokens.current().equals("end"),
				"Expected: 'end' but was '" + tokens.current() + "'");
		t.add(3); // end
		tokens.skip();
	}
}

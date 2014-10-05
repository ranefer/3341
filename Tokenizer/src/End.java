import java.util.ArrayList;

public class End {
	
	public static boolean isEnd(String token) {
		return token.equals("end");
	}
	
	public static void parse(Symbol symbol) {
		Reporter.Assert(symbol.hasCurrent() && symbol.current().equals("end"), "end");
		Tokens.add(3); // end
		symbol.skip();
	}
}

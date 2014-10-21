import java.util.ArrayList;

public class End {
	
	public static boolean isEnd(int token) {
		return token==3;
	}
	
	public static void parse(Tokens symbol) {
		Reporter.Assert(symbol.hasCurrent() && symbol.getToken()==3, "end");
		symbol.skip();
	}
}

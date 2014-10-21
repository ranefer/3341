import java.util.ArrayList;

public class Comma {

	public static boolean isComma(int token) {
		return token == 13;
	}

	public static void parse(Tokens symbols) {
		Reporter.Assert(symbols.hasCurrent() && isComma(symbols.getToken()), ";");
		symbols.skip();
	}
}

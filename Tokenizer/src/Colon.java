import java.util.ArrayList;

public class Colon {

	public static boolean isColon(int token) {
		return token == 12;
	}

	public static void parse(Tokens symbols) {
		Reporter.Assert(symbols.hasCurrent() && isColon(symbols.getToken()), ";");
		symbols.skip();
	}
}

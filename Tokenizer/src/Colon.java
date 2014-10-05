import java.util.ArrayList;

public class Colon {

	public static boolean isColon(String token) {
		return token.equals(";");
	}

	public static void parse(Symbol symbols) {
		Reporter.Assert(symbols.hasCurrent() && isColon(symbols.current()), ";");
		Tokens.add(12);
		symbols.skip();
	}
}

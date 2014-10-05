import java.util.ArrayList;

public class Comma {

	public static boolean isComma(String token) {
		return token.equals(",");
	}

	public static void parse(Symbol symbols) {
		Reporter.Assert(symbols.hasCurrent() && isComma(symbols.current()), ";");
		Tokens.add(13);
		symbols.skip();
	}
}

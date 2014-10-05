import java.util.ArrayList;

public class Input {

	public static boolean isInput(String token) {
		return token.equals("read");
	}

	public static void parse(Symbol symbols) {
		Reporter.Assert(symbols.hasCurrent() && isInput(symbols.current()), "read");
		Tokens.add(10);
		symbols.skip();

		Id.parse(symbols);
		Colon.parse(symbols);
	}
}

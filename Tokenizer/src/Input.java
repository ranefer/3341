import java.util.ArrayList;

public class Input {

	public static boolean isInput(int token) {
		return token == 10;
	}

	public static void parse(Tokens symbols) {
		Reporter.Assert(symbols.hasCurrent() && isInput(symbols.getToken()), "read");
		symbols.skip();

		Id.parse(symbols);
		Colon.parse(symbols);
	}
}

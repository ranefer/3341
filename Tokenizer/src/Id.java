import java.util.ArrayList;

public class Id {

	public static boolean isId(int token) {
		return token == 32;
	}

	public static void parse(Tokens symbols) {
		Reporter.Assert(symbols.hasCurrent() && isId(symbols.getToken()), "Id");
		symbols.skip();

		if (symbols.hasCurrent() && Comma.isComma(symbols.getToken())) {
			Comma.parse(symbols);
			Id.parse(symbols);
		}
	}
}

import java.util.ArrayList;

public class Id {

	public static boolean isId(String token) {
		return token.matches("[A-Z]+[0-9]*");
	}

	public static void parse(Symbol symbols) {
		Reporter.Assert(symbols.hasCurrent() && isId(symbols.current()), "Id");
		Tokens.add(32); // id
		symbols.skip();

		if (symbols.hasCurrent() && Comma.isComma(symbols.current())) {
			Comma.parse(symbols);
			Id.parse(symbols);
		}
	}
}

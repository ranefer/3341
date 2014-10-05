import java.util.ArrayList;

public class Output {

	public static boolean isOutput(String token) {
		return token.equals("write");
	}

	public static void parse(Symbol symbols) {
		Reporter.Assert(symbols.hasCurrent() && isOutput(symbols.current()), "Output");
		Tokens.add(11);
		symbols.skip();

		Id.parse(symbols);
		Colon.parse(symbols);
	}
}

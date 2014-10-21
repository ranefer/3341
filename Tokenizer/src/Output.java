import java.util.ArrayList;

public class Output {

	public static boolean isOutput(int token) {
		return token==11;
	}

	public static void parse(Tokens symbols) {
		Reporter.Assert(symbols.hasCurrent() && isOutput(symbols.getToken()), "Output");
		symbols.skip();

		Id.parse(symbols);
		Colon.parse(symbols);
	}
}

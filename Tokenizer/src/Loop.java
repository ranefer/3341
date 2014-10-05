import java.util.ArrayList;

public class Loop {

	public static boolean isLoop(String token) {
		return token.equals("while");
	}

	public static void parse(Symbol symbols) {
		Reporter.Assert(symbols.hasCurrent() && isLoop(symbols.current()), "Loop");
		symbols.skip();

		Condition.parse(symbols);

		Reporter.Assert(symbols.hasCurrent() && symbols.current().equals("loop"), "loop");
		symbols.skip();

		Statement.parse(symbols);
		End.parse(symbols);
		Colon.parse(symbols);
	}
}

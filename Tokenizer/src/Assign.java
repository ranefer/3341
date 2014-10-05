import java.util.ArrayList;

public class Assign {

	public static boolean isAssign(String token) {
		return Id.isId(token); // assign { id = expression }
	}

	public static void parse(Symbol tokens) {
		Reporter.Assert(tokens.hasCurrent() && isAssign(tokens.current()), "Id");
		Id.parse(tokens);

		parseEqualSign(tokens);

		Expression.parse(tokens);

		Colon.parse(tokens);
	}

	public static void parseEqualSign(Symbol symbols) {
		Reporter.Assert(symbols.hasCurrent() && symbols.current().equals("="), "=");
		Tokens.add(14);
		symbols.skip();
	}
}

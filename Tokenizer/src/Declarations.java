import java.util.ArrayList;

public class Declarations {

	public static boolean isDeclaration(String token) {
		return token.equals("int");
	}

	public static void parse(Symbol symbols) {
		Reporter.Assert(symbols.hasCurrent() && isDeclaration(symbols.current()), "int");
		Tokens.add(4); // int
		symbols.skip();

		Id.parse(symbols);

		Colon.parse(symbols);

		if (isDeclaration(symbols.current()))
			Declarations.parse(symbols);
	}
}

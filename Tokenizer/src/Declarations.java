import java.util.ArrayList;

public class Declarations {

	public static boolean isDeclaration(int token) {
		return token == 4; // int
	}

	public static void parse(Tokens symbols) {
		Reporter.Assert(symbols.hasCurrent() && isDeclaration(symbols.getToken()), "int");
		symbols.skip();

		Id.parse(symbols);

		Colon.parse(symbols);

		if (isDeclaration(symbols.getToken()))
			Declarations.parse(symbols);
	}
}

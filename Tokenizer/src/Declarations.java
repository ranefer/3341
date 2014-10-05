import java.util.ArrayList;

public class Declarations {

	public static boolean isDeclaration(String token) {
		return token.equals("int");
	}

	public static void parse(Token tokens, ArrayList<Integer> t) {
		Reporter.Assert(isDeclaration(tokens.current()),
				"Expected Declaration", t);
		t.add(4);
		tokens.skip();

		Id.parse(tokens, t);

		Colon.parse(tokens, t);

		if (isDeclaration(tokens.current()))
			Declarations.parse(tokens, t);
	}
}

import java.util.ArrayList;

public class Declarations {

	public static boolean isDeclaration(String token) {
		return token.equals("int");
	}

	public static void parse(Token tokens, ArrayList<Integer> t) {
		assert (isDeclaration(tokens.current()));
		t.add(4);
		tokens.skip();

		assert(tokens.hasCurrent() && Id.isId(tokens.current())) : "Expected id";
		Id.parse(tokens, t);
		
		assert(tokens.hasCurrent() && Colon.isColon(tokens.current())) : "Expected ';'";
		Colon.parse(tokens, t);

		if (isDeclaration(tokens.current()))
			Declarations.parse(tokens, t);
	}
}

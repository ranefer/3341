import java.util.ArrayList;

public class Declarations {

	public static boolean isDeclaration(String token) {
		return token.equals("int");
	}

	public static void parse(Token tokens, ArrayList<Integer> t) {
		assert (isDeclaration(tokens.current()));

		assert(tokens.hasNext() && Id.isId(tokens.next())) : "Expected id";
		Id.parse(tokens, t);
		
		assert(tokens.hasCurrent() && Colon.isColon(tokens.current())) : "Expected ';'";
		Colon.parse(tokens, t);

		if (isDeclaration(tokens.next()))
			Declarations.parse(tokens, t);
	}
}

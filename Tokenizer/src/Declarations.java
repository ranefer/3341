import java.util.ArrayList;

public class Declarations {

	public static boolean isDeclaration(String token) {
		return token.equals("int");
	}

	public static void parse(Token tokens) {
		Reporter.Assert(isDeclaration(tokens.current()), "Expected Declaration but was " + tokens.current());
		Tokenizer.result.add(4);
		tokens.skip();

		Id.parse(tokens);

		Colon.parse(tokens);

		if (isDeclaration(tokens.current()))
			Declarations.parse(tokens);
	}
}

import java.util.ArrayList;

public class Comma {

	public static boolean isComma(String token) {
		return token.equals(",");
	}

	public static void parse(Token tokens) {
		Reporter.Assert(isComma(tokens.current()), "Expected ';' but was " + tokens.current());
		Tokenizer.result.add(13);
		tokens.skip();
	}
}

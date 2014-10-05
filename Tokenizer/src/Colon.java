import java.util.ArrayList;

public class Colon {

	public static boolean isColon(String token) {
		return token.equals(";");
	}

	public static void parse(Token tokens) {
		Reporter.Assert(isColon(tokens.current()), "Expected ';'");
		Tokenizer.result.add(12);
		tokens.skip();
	}
}

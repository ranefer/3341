import java.util.ArrayList;

public class Input {

	public static boolean isInput(String token) {
		return token.equals("read");
	}

	public static void parse(Token tokens) {
		Reporter.Assert(isInput(tokens.current()), "Expected Input but was " + tokens.current());
		Tokenizer.result.add(10);
		tokens.skip();

		Id.parse(tokens);
		Colon.parse(tokens);
	}
}

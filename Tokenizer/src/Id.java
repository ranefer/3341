import java.util.ArrayList;

public class Id {

	public static boolean isId(String token) {
		return token.matches("[A-Z]+[0-9]*");
	}

	public static void parse(Token tokens) {
		Reporter.Assert(isId(tokens.current()), "Expected Id but was " + tokens.current());
		Tokenizer.result.add(32); // id
		tokens.skip();

		if (tokens.hasCurrent() && Comma.isComma(tokens.current())) {
			Comma.parse(tokens);
			Id.parse(tokens);
		}
	}
}

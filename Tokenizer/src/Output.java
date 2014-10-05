import java.util.ArrayList;

public class Output {

	public static boolean isOutput(String token) {
		return token.equals("write");
	}

	public static void parse(Token tokens) {
		Reporter.Assert(isOutput(tokens.current()), "Expected Output");
		Tokenizer.result.add(11);
		tokens.skip();

		Id.parse(tokens);
		Colon.parse(tokens);
	}
}

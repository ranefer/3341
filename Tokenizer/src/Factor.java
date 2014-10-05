import java.util.ArrayList;

public class Factor {

	public static boolean isFactor(String token) {
		return Op.isOp(token); // Factor = { Op | Op * Factor }
	}

	public static void parse(Token tokens) {
		Reporter.Assert(isFactor(tokens.current()), "Expected Factor but was " + tokens.current());
		Op.parse(tokens);

		if (tokens.hasCurrent() && tokens.equals("*")) {
			Tokenizer.result.add(24);
			Factor.parse(tokens);
		}
	}
}

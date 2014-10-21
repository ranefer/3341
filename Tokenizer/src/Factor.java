import java.util.ArrayList;

public class Factor {

	public static boolean isFactor(int token) {
		return Op.isOp(token); // Factor = { Op | Op * Factor }
	}

	public static void parse(Tokens tokens) {
		Reporter.Assert(tokens.hasCurrent() && isFactor(tokens.getToken()), "Factor");
		Op.parse(tokens);

		if (tokens.hasCurrent() && tokens.equals("*")) {
			Factor.parse(tokens);
		}
	}
}

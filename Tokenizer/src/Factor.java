import java.util.ArrayList;

public class Factor {

	public static boolean isFactor(String token) {
		return Op.isOp(token); // Factor = { Op | Op * Factor }
	}

	public static void parse(Symbol tokens) {
		Reporter.Assert(tokens.hasCurrent() && isFactor(tokens.current()), "Factor");
		Op.parse(tokens);

		if (tokens.hasCurrent() && tokens.equals("*")) {
			Tokens.add(24);
			Factor.parse(tokens);
		}
	}
}

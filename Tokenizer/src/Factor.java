import java.util.ArrayList;

public class Factor {

	public static boolean isFactor(String token) {
		return Op.isOp(token); // Factor = { Op | Op * Factor }
	}

	public static void parse(Token tokens, ArrayList<Integer> t) {
		Reporter.Assert(isFactor(tokens.current()), "Expected Factor");
		Op.parse(tokens, t);

		if (tokens.hasCurrent() && tokens.equals("*")) {
			t.add(24);
			Factor.parse(tokens, t);
		}
	}
}

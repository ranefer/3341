import java.util.ArrayList;

public class Factor {

	public static boolean isFactor (String token) {
		return Op.isOp(token); // Factor = { Op | Op * Factor }
	}

	public static void parse(Token tokens, ArrayList<Integer> t) {
		assert(isFactor(tokens.current()));
		Op.parse(tokens, t);
		
		if(tokens.hasCurrent() && tokens.equals("*")) {
			t.add(24);
			assert(Factor.isFactor(tokens.current()));
			Factor.parse(tokens, t);
		}
	}
}

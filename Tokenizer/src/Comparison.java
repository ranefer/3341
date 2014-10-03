import java.util.ArrayList;

public class Comparison {

	public static boolean isComparison(String token) {
		return token.equals("(");
	}

	public static void parse(Token tokens, ArrayList<Integer> t) {
		assert (isComparison(tokens.current()));

		parseOpenParen(tokens, t);
		
		assert(tokens.hasCurrent() && Op.isOp(tokens.current())) : "Expected Op";
		Op.parse(tokens, t);

		parseCompareOperator(tokens, t);
		
		assert(tokens.hasCurrent() && Op.isOp(tokens.current())) : "Expected Op";
		Op.parse(tokens, t);

		parseClosedParen(tokens, t);
	}

	private static void parseOpenParen(Token tokens, ArrayList<Integer> t) {
		assert (tokens.current().equals("(")) : "Expected '('";
		t.add(20); // (

		tokens.skip();
	}

	private static void parseClosedParen(Token tokens, ArrayList<Integer> t) {
		assert (tokens.current().equals(")")) : "Expected ')'";
		t.add(21); // )

		tokens.skip();
	}

	private static void parseCompareOperator(Token tokens, ArrayList<Integer> t) {
		if (tokens.hasNext()) {
			switch (tokens.current()) {
			case "!=":
				t.add(25);
				break;
			case "==":
				t.add(26);
				break;
			case "<":
				t.add(27);
				break;
			case ">":
				t.add(28);
				break;
			case "<=":
				t.add(29);
				break;
			case ">=":
				t.add(30);
				break;
			default:
				assert (false) : "Exptected a comparision but was "
						+ tokens.current();
			}
		} else
			assert (false) : "Exptected a comparision but was "
					+ tokens.current();

		tokens.skip();
	}


}

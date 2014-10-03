import java.util.ArrayList;

public class Op {

	public static boolean isOp(String token) {
		boolean result = false;

		result = result || token.matches("[0-9]+");
		result = result || Id.isId(token);
		result = result || token.equals("(");

		return result;
	}

	public static void parse(Token tokens, ArrayList<Integer> t) {
		assert(isOp(tokens.current()));
		
		String alternative = tokens.current();
	
		if(alternative.matches("[0-9]+"))  {
			t.add(31); // integer
		} else if(Id.isId(alternative)) {
			Id.parse(tokens, t);
		} else if(alternative.equals("(")) {
			t.add(20); // (
			Expression.parse(tokens, t);
			assert(tokens.current().equals(")")) : "Expected ')'";
			t.add(21); // )
		} else 
			assert(false) : "Expected Op";
	}
}

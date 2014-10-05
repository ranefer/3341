import java.util.ArrayList;

public class Op {

	public static boolean isOp(String token) {
		boolean result = false;

		result = result || token.matches("[0-9]+");
		result = result || Id.isId(token);
		result = result || token.equals("(");

		return result;
	}

	public static void parse(Token tokens) {
		Reporter.Assert(isOp(tokens.current()), "Expected Op but was " + tokens.current());

		String alternative = tokens.current();

		if (alternative.matches("[0-9]+")) {
			Tokenizer.result.add(31); // integer
			tokens.skip();
		} else if (Id.isId(alternative)) {
			Id.parse(tokens);
		} else if (alternative.equals("'(' but was "+ tokens.current())) {
			Tokenizer.result.add(20); // (
			Expression.parse(tokens);
			Reporter.Assert (tokens.current().equals(")"), "Expected ')' but was "+ tokens.current());
			Tokenizer.result.add(21); // )
			tokens.skip();
		} else
			Reporter.Assert (false,"Expected Op but was "+ tokens.current());
	}
}

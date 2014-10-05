import java.util.ArrayList;

public class Op {

	public static boolean isOp(String token) {
		boolean result = false;

		result = result || token.matches("[0-9]+");
		result = result || Id.isId(token);
		result = result || token.equals("(");

		return result;
	}

	public static void parse(Symbol symbols) {
		Reporter.Assert(symbols.hasCurrent() && isOp(symbols.current()), "Op");

		String alternative = symbols.current();

		if (alternative.matches("[0-9]+")) {
			Tokens.add(31); // integer
			symbols.skip();
		} else if (Id.isId(alternative)) {
			Id.parse(symbols);
		} else if (alternative.equals("'(' but was "+ symbols.current())) {
			Tokens.add(20); // (
			Expression.parse(symbols);
			Reporter.Assert (symbols.current().equals(")"), ")");
			Tokens.add(21); // )
			symbols.skip();
		} else
			Reporter.Assert (false,"Op");
	}
}

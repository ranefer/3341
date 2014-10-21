public class Op implements Production {

	public static boolean isOp(int token) {
		boolean result = false;

		result = result || token == 31; // Integer
		result = result || token == 32; // ID
		result = result || token == 20; // (

		return result;
	}

	public void parse(Tokens tokens) {
		Reporter.Assert(tokens.hasCurrent() && isOp(tokens.getToken()), "Op");

		int alternative = tokens.getToken();

		if (IntegerValue.isOp(alternative)) {
			tokens.skip();
		} else if (Id.isId(alternative)) {
			Id.parse(tokens);
		} else if (alternative == 20) { // (
			Expression.parse(tokens);
			Reporter.Assert(tokens.getToken() == 21, ")"); // )
			tokens.skip();
		} else
			Reporter.Assert(false, "Op");
	}

	public void execute() {

	}

	public void print() {

	}

}

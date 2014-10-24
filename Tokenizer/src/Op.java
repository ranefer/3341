public class Op implements NumericProduction{
	NumericProduction body;
	boolean hasParen;

	public Op() {
		hasParen = false;
	}

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

		if (IntegerValue.isInt(alternative)) {
			body = new IntegerValue();
			body.parse(tokens);
		} else if (Id.isId(alternative)) {
			body = new Id();
			body.parse(tokens);
		} else if (alternative == 20) { // (
			body = new Expression();
			body.parse(tokens);
			Reporter.Assert(tokens.getToken() == 21, ")"); // )
		} else
			Reporter.Assert(false, "Op");
	}

	public int value() {
		int result = body.value(); ;
		return result;
	}

	public void print(int tabStop) {
		if (hasParen) {
			System.out.print("(");
			body.print(tabStop);
			System.out.print(")");
		} else if (body != null)
			body.print(tabStop);
	}
}

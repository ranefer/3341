public class Comparison implements Production {
	Production op1;
	Production op2;

	String compareOperator;

	public static boolean isComparison(int token) {
		return token == 20; // (
	}

	public void parse(Tokens symbols) {
		Reporter.Assert(symbols.hasCurrent()
				&& isComparison(symbols.getToken()), "(");

		parseOpenParen(symbols);

		op1.parse(symbols);

		parseCompareOperator(symbols);

		op2.parse(symbols);

		parseClosedParen(symbols);
	}

	private static void parseOpenParen(Tokens symbols) {
		Reporter.Assert(symbols.hasCurrent() && symbols.getToken() == 20, "(");
		symbols.skip();
	}

	private static void parseClosedParen(Tokens symbols) {
		Reporter.Assert(symbols.hasCurrent() && symbols.getToken() == 21, ")");
		symbols.skip();
	}

	private void parseCompareOperator(Tokens symbols) {
		if (symbols.hasCurrent()) {
			switch (symbols.getToken()) {
			case 25: // !=
				compareOperator = "!=";
				break;
			case 26: // ==
				compareOperator = "==";
				break;
			case 27: // <
				compareOperator = "<";
				break;
			case 28: // >
				compareOperator = ">";
				break;
			case 29: // <=
				compareOperator = "<=";
				break;
			case 30: // >=
				compareOperator = ">=";
				break;
			default:
				Reporter.Assert(false, "comparision");
			}
		} else
			Reporter.Assert(false, "comparision");

		symbols.skip();
	}

	public void execute() {
		System.out.println("(");
		op1.print();
		System.out.println(compareOperator);
		op2.print();
		System.out.println(")");
	}

	public void print() {

	}
}

public class Comparison implements BooleanProduction {
	NumericProduction op1;
	NumericProduction op2;

	String compareOperator;

	public Comparison() {
		op1 = new Op();
		op2 = new Op();
	}

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

	public boolean evaluate() {
		NumericProduction np1 = (NumericProduction) op1;
		NumericProduction np2 = (NumericProduction) op2;

		boolean result = false;
		switch (compareOperator) {
		case "!=":
			result =np1.value()!=np2.value();
			break;
		case "==":
			result =np1.value()==np2.value();
			break;
		case "<":
			result =np1.value()<np2.value();
			break;
		case ">":
			result =np1.value()>np2.value();
			break;
		case "<=":
			result =np1.value()<=np2.value();
			break;
		case ">=":
			result =np1.value()>=np2.value();
			break;

		}
			return result;
	}

	public void print(int tabStop) {
		System.out.print("(");
		op1.print(tabStop);
		System.out.print(compareOperator);
		op2.print(tabStop);
		System.out.print(")");
	}
}

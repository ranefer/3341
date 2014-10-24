public class IntegerValue implements NumericProduction {
	
	String value;
	
	public static boolean isInt(int token) {
		return token == 31;
	}

	@Override
	public void parse(Tokens tokens) {
		Reporter.Assert(tokens.hasCurrent() && isInt(tokens.getToken()), "integer value");
		value = tokens.getSymbol();
		tokens.skip();
	}

	@Override
	public int value() {
		return Integer.valueOf(value);
	}

	@Override
	public void print(int tabStop) {
		System.out.print(value);
	}

}

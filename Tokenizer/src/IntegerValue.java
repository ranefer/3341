public class IntegerValue implements Production {
	
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
	public void execute() {
	}

	@Override
	public void print(int tabStop) {
		System.out.print(value);
	}

}

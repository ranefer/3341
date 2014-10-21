public class Reporter {
	private static Tokens symbols;

	public static void Assert(boolean b, String symbol) {
		if (b)
			return;
		Report();
		System.out.println();
		System.out.print("Expected '" + symbol + "'");
		if (symbols != null && symbols.hasCurrent())
			System.out.print(" but was " + symbols.getToken());
		System.out.println();

		System.exit(10);
	}

	public static void Report() {
	}

	public static void setTokenss(Tokens symbols) {
		Reporter.symbols = symbols;
	}

	public void execute() {

	}

	public void print() {

	}

}

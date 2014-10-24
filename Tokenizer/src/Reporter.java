public class Reporter {
	private static Symbol symbols;

	public static void Assert(boolean b, String symbol) {
		if (b)
			return;
		Report();
		System.out.println();
		System.out.print("Expected '" + symbol + "'");
		if (symbols != null && symbols.hasCurrent())
			System.out.print(" but was " + symbols.getSymbol());
		System.out.println();

		System.exit(10);
	}

	public static void Report() {
	}

	public static void setSymbols(Symbol symbols) {
		Reporter.symbols = symbols;
	}
}

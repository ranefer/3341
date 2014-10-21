
public class Reporter {
	private static Tokens symbols;

	public static void Assert(boolean b, String symbol) {
		if (b)
			return;
		Report();
		System.out.println();
        System.out.print("Expected '" + symbol + "'");
		if(symbols != null && symbols.hasCurrent())
			System.out.print(" but was " + symbols.getToken());
		System.out.println();

		System.exit(10);
	}
	
	public static void Report() {
		System.out.println(Tokens.toTokenString());
	}
	
	public static void setTokenss(Tokens symbols) {
		Reporter.symbols = symbols;
	}
	
}

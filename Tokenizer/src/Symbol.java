import java.util.ArrayList;

public class Symbol {

	ArrayList<String> symbols;
	private int index;

	public Symbol(ArrayList<String> symbols) {
		index = 0;
		this.symbols = symbols;
		this.symbols.add("_EOF");
	}

	public String getSymbol() throws IndexOutOfBoundsException {
		String symbol = symbols.get(index);
        symbol = symbol.replaceAll("[A-Z]+[0-9]*",
                "_IDENTIFIER");
        symbol = symbol.replaceAll("[0-9]+", "_INTEGER");
	
		return doubleCheckNext(symbol);
	}

	public void skip() {
		//System.out.println(getSymbol());
		index++;
	}

	public boolean hasCurrent() {
		return index < this.symbols.size() - 1;
	}

	public void reset() {
		this.index = 0;
	}

	private String doubleCheckNext(String symbol) {
		String next = "";
		try {
			next = symbols.get(index + 1);
		} catch (Exception e) {
		}

		switch (symbol) {
		case "=":
			if (next.equals("=")) {
				index++;
				return symbol + next;
			}
			return symbol;
		case "!":
			if (next.equals("=")) {
				index++;
				return symbol + next;
			}
			return symbol;

		case "<":
			if (next.equals("=")) {
				index++;
				return symbol + next;
			}
			return symbol;

		case ">":
			if (next.equals("=")) {
				index++;
				return symbol + next;
			}
			return symbol;
		default:
			return symbol;
		}
	}
	public String getSourceSymbol() {
		return this.symbols.get(index);
	}

}
import java.util.ArrayList;

public class Symbol {

	ArrayList<String> symbols;
	private int index;

	public Symbol(ArrayList<String> symbols) {
		index = -1;
		this.symbols = symbols;
		this.symbols.add("_EOF");
	}

	public String next() throws IndexOutOfBoundsException {
		String symbol = symbols.get(++index);
		return doubleCheckNext(symbol);
	}

	public void skip() {
		index++;
	}

	public boolean hasNext() {
		return index < this.symbols.size() - 1;
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
}
import java.util.ArrayList;

public class Symbol implements Production {

	ArrayList<String> symbols;
	private int index;

	public Symbol(ArrayList<String> symbols) {
		index = 0;
		this.symbols = symbols;
		this.symbols.add("_EOF");
	}

	public String getSymbol() throws IndexOutOfBoundsException {
		String symbol = symbols.get(index);
		return doubleCheckNext(symbol);
	}

	public void skip() {
		index++;
	}

	public boolean hasCurrent() {
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

	public void execute() {

	}

	public void print() {

	}

}
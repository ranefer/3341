import java.util.ArrayList;

public class Symbol {

	ArrayList<String> symbols;
	private int currentSymbol;
	private String SYMBOL;

	public Symbol(ArrayList<String> symbols) {
		currentSymbol = 0;
		this.symbols = symbols;
	}

	public String next() throws IndexOutOfBoundsException {
		currentSymbol++;
		setSymbol();
		return symbols.get(currentSymbol);
	}

	public void skip() {
		currentSymbol++;
	}

	public String current() throws IndexOutOfBoundsException {
		setSymbol();
		return symbols.get(currentSymbol);
	}

	public boolean hasCurrent() {
		return symbols.size() > currentSymbol;
	}

	public boolean hasNext() {
		return symbols.size() > currentSymbol + 1;
	}
	
	private void setSymbol(){
		this.SYMBOL = symbols.get(currentSymbol);
	}
}

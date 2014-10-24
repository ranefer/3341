import java.util.ArrayList;
import java.util.Hashtable;

public class Tokens {
	private static ArrayList<Integer> tokens = new ArrayList<Integer>();
	private Symbol symbols;

	Hashtable<String, Integer> tokenizer;

	public Tokens(Symbol symbols) {
		this.symbols = symbols;
		tokenizer = new Hashtable<String, Integer>();
		setTokenizerMapping();
	}

	public int getToken() {
		int result = -1;
		try {
			result = tokenizer.get(symbols.getSymbol());
		} catch (Exception e) {
			System.out.println("Error");
			System.exit(10);
		}
		return result;
	}

	public boolean hasCurrent() {
		return symbols.hasCurrent();
	}

	public void reset() {
		symbols.reset();
	}

	public void skip() {
		symbols.skip();
	}

	private void setTokenizerMapping() {
		tokenizer.put("program", 1);
		tokenizer.put("begin", 2);
		tokenizer.put("end", 3);
		tokenizer.put("int", 4);
		tokenizer.put("if", 5);
		tokenizer.put("then", 6);
		tokenizer.put("else", 7);
		tokenizer.put("while", 8);
		tokenizer.put("loop", 9);
		tokenizer.put("read", 10);
		tokenizer.put("write", 11);
		tokenizer.put(";", 12);
		tokenizer.put(",", 13);
		tokenizer.put("=", 14);
		tokenizer.put("!", 15);
		tokenizer.put("[", 16);
		tokenizer.put("]", 17);
		tokenizer.put("&&", 18);
		tokenizer.put("||", 19);
		tokenizer.put("(", 20);
		tokenizer.put(")", 21);
		tokenizer.put("+", 22);
		tokenizer.put("-", 23);
		tokenizer.put("*", 24);
		tokenizer.put("!=", 25);
		tokenizer.put("==", 26);
		tokenizer.put("<", 27);
		tokenizer.put(">", 28);
		tokenizer.put("<=", 29);
		tokenizer.put(">=", 30);
		tokenizer.put("_INTEGER", 31);
		tokenizer.put("_IDENTIFIER", 32);
		tokenizer.put("_EOF", 33);
	}
	public String getSymbol() {
		return this.symbols.getSourceSymbol();
	}
}

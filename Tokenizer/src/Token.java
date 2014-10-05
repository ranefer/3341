import java.util.ArrayList;

public class Token {

	ArrayList<String> tokens;
	private int currentToken;

	public Token(ArrayList<String> tokens) {
		currentToken = 0;
		this.tokens = tokens;
	}

	public String next() throws IndexOutOfBoundsException {
		assert (hasNext());
		return tokens.get(++currentToken);
	}

	public void skip() {
		currentToken++;
	}

	public String current() throws IndexOutOfBoundsException {
		Reporter.Assert(hasCurrent(), "Not expecting EOF");
		return tokens.get(currentToken);
	}

	public boolean hasCurrent() {
		return tokens.size() > currentToken;
	}

	public boolean hasNext() {
		return tokens.size() > currentToken + 1;
	}
}

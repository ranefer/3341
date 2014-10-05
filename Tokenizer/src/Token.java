import java.util.ArrayList;

public class Token {

	ArrayList<String> tokens;
	private int currentToken;
	private String TOKEN;

	public Token(ArrayList<String> tokens) {
		currentToken = 0;
		this.tokens = tokens;
	}

	public String next() throws IndexOutOfBoundsException {
		assert (hasNext());
		currentToken++;
		setToken();
		return tokens.get(currentToken);
	}

	public void skip() {
		currentToken++;
	}

	public String current() throws IndexOutOfBoundsException {
		Reporter.Assert(hasCurrent(), "Not expecting EOF");
		setToken();
		return tokens.get(currentToken);
	}

	public boolean hasCurrent() {
		return tokens.size() > currentToken;
	}

	public boolean hasNext() {
		return tokens.size() > currentToken + 1;
	}
	
	private void setToken(){
		this.TOKEN = tokens.get(currentToken);
	}
}

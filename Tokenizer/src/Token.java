import java.io.BufferedReader;
import java.io.IOException;


public class Token {

	
	String[] tokens;
	private int currentToken;
	
	public Token(String[] tokens) {
		currentToken = 0;
		this.tokens = tokens;
	}
	
	public String next() throws IndexOutOfBoundsException {
		assert(hasNext());
		return tokens[++currentToken];
	}
	

	public void skip() {
		currentToken++;
	}
	
	public String current() throws IndexOutOfBoundsException {
		return tokens[currentToken];
	}
	public boolean hasCurrent() {
		return tokens.length > currentToken;
	}
	
	public boolean hasNext() {
		return tokens.length > currentToken + 1;
	}
}

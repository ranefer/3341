import java.io.BufferedReader;
import java.io.IOException;


public class Token {

	
	String[] tokens;
	int currentToken;
	
	public Token(String[] tokens) {
		currentToken = 0;
		this.tokens = tokens;
	}
	
	public String next() throws IndexOutOfBoundsException {
		currentToken++;
		if(!this.hasNext()) {
			throw new IndexOutOfBoundsException();
		} else  {
            return tokens[currentToken];
		}
	}
	

	public void skip() {
		currentToken++;
	}
	
	public String current() throws IndexOutOfBoundsException {
		if(!this.hasNext()) {
			throw new IndexOutOfBoundsException();
		} else  {
			System.out.println(tokens[currentToken]);
            return tokens[currentToken];
		}
	}
	
	public Boolean hasNext() {
		return tokens.length > currentToken;
	}
}

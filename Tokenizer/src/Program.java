import java.io.BufferedReader;
import java.util.ArrayList;


public class Program {

public final String[] RESERVED = {"program", "begin", "end", "if", "int", "if", "then", "else", "while", "loop", "read", "write"};

	public static boolean isProgram(String token) {
		return token.equals("program");
	}
	
	public static void parse(Token tokens, ArrayList<Integer> t) {
		assert(isProgram(tokens.current())): "Expected: program but was '" + tokens.current() + "'";;
		t.add(1); // program
		
        assert(tokens.hasNext() && Declarations.isDeclaration(tokens.current())) : "Expected delcaration";
		Declarations.parse(tokens, t);

		assert(tokens.hasCurrent()) : "Exptectd 'begin'";
        parseBegin(tokens, t);
		
		assert(tokens.hasCurrent() && StatementSequence.isStatementSequence(tokens.current())) : "Expected Statement Sequence";
        StatementSequence.parse(tokens, t);
		
        assert(tokens.hasCurrent()) : "Exptected 'end'";
		parseEnd(tokens, t);

    	assert(!tokens.hasNext()) : "Expected end of file";
    	t.add(33); // EOF
	}

	private static void parseBegin(Token tokens, ArrayList<Integer> t) {
		assert(tokens.current().equals("begin")) : "Expected: begin but was '" + tokens.current() + "'";
		t.add(2); // begin
		tokens.skip();
	}

	private static void parseEnd(Token tokens, ArrayList<Integer> t) {
		assert(tokens.current().equals("end")) : "Expected: end but was '" + tokens.current() + "'";
		t.add(3); // end
		tokens.skip();
	}
}

import java.io.BufferedReader;
import java.util.ArrayList;


public class Program {

public final String[] RESERVED = {"program", "begin", "end", "if", "int", "if", "then", "else", "while", "loop", "read", "write"};

	public static void parse(Token tokens, ArrayList<Integer> t) {
		parseProgram(tokens, t);
		
		if(Declarations.isDeclaration(tokens.current()))
            Declarations.parse(tokens, t);

		parseBegin(tokens, t);
		
		if(StatementSequence.isStatementSequence(tokens.current()))
            StatementSequence.parse(tokens, t);
		
		parseEnd(tokens, t);

    	t.add(33); // EOF
    	assert(!tokens.hasNext()) : "Expected end of file";

	}
	
	private static void parseProgram(Token tokens, ArrayList<Integer> t) {
		String program = "";
		if(tokens.hasNext()) 
        	program = tokens.current();
		assert(program.equals("program")) : "Expected: program but was '" + program + "'";
		
		t.add(1); // program
		tokens.skip();
	}
	
	private static void parseBegin(Token tokens, ArrayList<Integer> t) {
        String begin = "";
		if(tokens.hasNext())
			begin = tokens.current();
		assert(begin.equals("begin")) : "Expected: begin but was '" + begin + "'";
		
		t.add(2); // begin
		tokens.skip();
	}

	private static void parseEnd(Token tokens, ArrayList<Integer> t) {
		String end = "";
		if(tokens.hasNext())
			end = tokens.current();
		assert(end.equals("end")) : "Expected: end but was '" + end + "'";
		
		t.add(3); // end
		tokens.skip();
	}
	
	
}

import java.util.ArrayList;

public class Program {

	public final String[] RESERVED = { "program", "begin", "end", "if", "int",
			"if", "then", "else", "while", "loop", "read", "write" };

	public static boolean isProgram(String token) {
		return token.equals("program");
	}

	public static void parse(Token tokens, ArrayList<Integer> t) {
		Reporter.Assert(tokens.hasCurrent() && isProgram(tokens.current()),
				"Expected: program but was '" + tokens.current() + "'");
		tokens.skip();
		t.add(1); // program

		Declarations.parse(tokens, t);

		parseBegin(tokens, t);

		Statement.parse(tokens, t);

		End.parse(tokens, t);

		Reporter.Assert(!tokens.hasCurrent(), "Expected end of file");
		t.add(33); // EOF
	}

	private static void parseBegin(Token tokens, ArrayList<Integer> t) {
		Reporter.Assert(tokens.hasCurrent() && tokens.current().equals("begin"),
				"Expected: begin but was '" + tokens.current() + "'");
		t.add(2); // begin
		tokens.skip();
	}

	
}

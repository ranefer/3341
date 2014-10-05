import java.util.ArrayList;

public class Program {

	public final String[] RESERVED = { "program", "begin", "end", "if", "int",
			"if", "then", "else", "while", "loop", "read", "write" };

	public static boolean isProgram(String token) {
		return token.equals("program");
	}

	public static void parse(Token tokens, ArrayList<Integer> t) {
		Reporter.Assert(isProgram(tokens.current()),
				"Expected: program but was '" + tokens.current() + "'", t);
		tokens.skip();
		t.add(1); // program

		Declarations.parse(tokens, t);

		parseBegin(tokens, t);

		Statement.parse(tokens, t);

		parseEnd(tokens, t);

		Reporter.Assert(!tokens.hasNext(), "Expected end of file", t);
		t.add(33); // EOF
	}

	private static void parseBegin(Token tokens, ArrayList<Integer> t) {
		Reporter.Assert(tokens.current().equals("begin"),
				"Expected: begin but was '" + tokens.current() + "'", t);
		t.add(2); // begin
		tokens.skip();
	}

	private static void parseEnd(Token tokens, ArrayList<Integer> t) {
		Reporter.Assert(tokens.current().equals("end"),
				"Expected: end but was '" + tokens.current() + "'", t);
		t.add(3); // end
		tokens.skip();
	}
}

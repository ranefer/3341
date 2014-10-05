import java.util.ArrayList;

public class Program {

	public final String[] RESERVED = { "program", "begin", "end", "if", "int",
			"if", "then", "else", "while", "loop", "read", "write" };

	public static boolean isProgram(String token) {
		return token.equals("program");
	}

	public static void parse(Token tokens) {
		Reporter.Assert(isProgram(tokens.current()),
				"Expected: program but was '" + tokens.current() + "'");
		tokens.skip();
		Tokenizer.result.add(1); // program

		Declarations.parse(tokens);

		parseBegin(tokens);

		Statement.parse(tokens);

		parseEnd(tokens);

		Reporter.Assert(!tokens.hasNext(), "Expected end of file but was " + tokens.current());
		Tokenizer.result.add(33); // EOF
	}

	private static void parseBegin(Token tokens) {
		Reporter.Assert(tokens.current().equals("begin"),
				"Expected: begin but was '" + tokens.current() + "'");
		Tokenizer.result.add(2); // begin
		tokens.skip();
	}

	private static void parseEnd(Token tokens) {
		Reporter.Assert(tokens.current().equals("end"),
				"Expected: end but was '" + tokens.current() + "'");
		Tokenizer.result.add(3); // end
		tokens.skip();
	}
}

import java.util.ArrayList;

public class Program {

	public final String[] RESERVED = { "program", "begin", "end", "if", "int",
			"if", "then", "else", "while", "loop", "read", "write" };

	public static boolean isProgram(String token) {
		return token.equals("program");
	}

	public static void parse(Symbol symbols) {
		Reporter.Assert(symbols.hasCurrent() && isProgram(symbols.current()),
				"program");
		symbols.skip();
		Tokens.add(1); // program

		Declarations.parse(symbols);

		parseBegin(symbols);

		Statement.parse(symbols);

        End.parse(symbols);

		Reporter.Assert(!symbols.hasCurrent(), "end of file");
		Tokens.add(33); // EOF
	}

	private static void parseBegin(Symbol tokens) {
		Reporter.Assert(tokens.hasCurrent() && tokens.current().equals("begin"),
				"begin");
		Tokens.add(2); // begin
		tokens.skip();
	}

}

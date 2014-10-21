import java.util.ArrayList;

public class Program {

	public final String[] RESERVED = { "program", "begin", "end", "if", "int",
			"if", "then", "else", "while", "loop", "read", "write" };

	public static boolean isProgram(int token) {
		return token == 1;
	}

	public static void parse(Tokens symbols) {
		Reporter.Assert(symbols.hasCurrent() && isProgram(symbols.getToken()),
				"program");
		symbols.skip();

		Declarations.parse(symbols);

		parseBegin(symbols);

		Statement.parse(symbols);

        End.parse(symbols);

		Reporter.Assert(!symbols.hasCurrent(), "end of file");
	}

	private static void parseBegin(Tokens tokens) {
		Reporter.Assert(tokens.hasCurrent() && tokens.getToken()==2,
				"begin");
		tokens.skip();
	}

}

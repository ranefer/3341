public class Program implements Production {

	public final String[] RESERVED = { "program", "begin", "end", "if", "int",
			"if", "then", "else", "while", "loop", "read", "write" };

	Production declarations;
	Production statementSequence;

	public Program() {
		declarations = new Declarations();
		statementSequence = new StatementSequence();
	}

	public static boolean isProgram(int token) {
		return token == 1;
	}

	public void parse(Tokens symbols) {
		Reporter.Assert(symbols.hasCurrent() && isProgram(symbols.getToken()),
				"program");
		symbols.skip();

		declarations.parse(symbols);

		parseBegin(symbols);

		statementSequence.parse(symbols);

		End.parse(symbols);

		Reporter.Assert(!symbols.hasCurrent(), "end of file");
	}

	private void parseBegin(Tokens tokens) {
		Reporter.Assert(tokens.hasCurrent() && tokens.getToken() == 2, "begin");
		tokens.skip();
	}

	public void execute() {

	}

	public void print(int tabStop) {
		System.out.println("program");
		declarations.print(tabStop);
		System.out.println("begin");
		statementSequence.print(tabStop);
		End.print();
	}

}

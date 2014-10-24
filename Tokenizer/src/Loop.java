public class Loop implements Production {

	Production condition;
	Production statement;

	public static boolean isLoop(int token) {
		return token == 9;
	}

	public void parse(Tokens tokens) {
		Reporter.Assert(tokens.hasCurrent() && isLoop(tokens.getToken()),
				"while");
		tokens.skip();

		condition.parse(tokens);

		Reporter.Assert(tokens.hasCurrent() && Loop.isLoop(tokens.getToken()),
				"loop");
		tokens.skip();

		statement.parse(tokens);
		End.parse(tokens);
		SemiColon.parse(tokens);
	}

	public void execute() {

	}

	public void print() {
		System.out.print("while ");
		condition.print();
		System.out.println(" loop ");
		statement.print();
		End.print();
	}

}
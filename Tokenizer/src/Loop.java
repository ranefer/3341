public class Loop implements Production {

	Condition condition;
	Production statement;

	public Loop() {
		condition = new Condition();
		statement = new StatementSequence();
	}

	public static boolean isLoop(int token) {
		return token == 8 || token == 9;
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
		while(condition.evaluate()) {
			statement.execute();
		}
	}

	public void print(int tabStop) {
		System.out.print("while ");
		condition.print(tabStop);
		System.out.println(" loop ");
		statement.print(tabStop + Tab.space);
		End.print(tabStop);
		SemiColon.print();
	}

}

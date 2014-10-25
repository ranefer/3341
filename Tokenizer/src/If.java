public class If implements Production {

	Condition condition;
	Production ifStatement;
	Production elseStatement;

	public If() {
		condition = new Condition();
		ifStatement = new StatementSequence();
	}

	public static boolean isIf(int token) {
		return token == 5;
	}

	public void parse(Tokens tokens) {
		Reporter.Assert(isIf(tokens.getToken()), "if");
		tokens.skip();

		condition.parse(tokens);

		Reporter.Assert(tokens.hasCurrent() && tokens.getToken() == 6, "then");
		tokens.skip();

		ifStatement.parse(tokens);

		parseElse(tokens);

		End.parse(tokens);

		SemiColon.parse(tokens);
	}

	private void parseElse(Tokens tokens) {
		if (tokens.hasCurrent()) {
			if (tokens.getToken() == 7) { // else
				tokens.skip();
				elseStatement = new Statement();
				if (Statement.isStatement(tokens.getToken()))
					elseStatement.parse(tokens);
			}
		}
	}

	public void execute() {
		if(condition.evaluate())
			ifStatement.execute();
		else if (elseStatement != null)
			elseStatement.execute();
	}

	public void print(int tabStop) {
		System.out.print("if ");
		condition.print(tabStop);
		System.out.println(" then");

		ifStatement.print(tabStop + Tab.space);
		if (elseStatement != null) { 
            Tab.print(tabStop);
			System.out.println("else ");
			elseStatement.print(tabStop + Tab.space);
		}
		End.print(tabStop);
		SemiColon.print();
	}
}

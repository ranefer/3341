
public class StatementSequence implements Production {

		Production statement;
		Production ss;

		public StatementSequence() {
			statement = new Statement();
		}

		public static boolean isStatementSequence(int token) {
			return Statement.isStatement(token);
		}

		public void parse(Tokens tokens) {
			Reporter.Assert(tokens.hasCurrent() && isStatementSequence(tokens.getToken()),
			"Statement");
			statement.parse(tokens);
			if(StatementSequence.isStatementSequence(tokens.getToken())) {
				ss = new StatementSequence();
                                ss.parse(tokens);
			}
		}

		public void execute() {
			statement.execute();
			if(ss != null)
				ss.execute();
		}

		public void print(int tabStop) {
			statement.print(tabStop);
			if (ss != null)
				ss.print(tabStop);
		}

	}


public class Statement implements Production {

	Production body;

	public Statement() {
	}

	public static boolean isStatement(int token) {
		boolean result = false;
		result = result || Assign.isAssign(token);
		result = result || If.isIf(token);
		result = result || Loop.isLoop(token);
		result = result || Input.isInput(token);
		result = result || Output.isOutput(token);
		return result;
	}

	public void parse(Tokens tokens) {
		Reporter.Assert(tokens.hasCurrent() && isStatement(tokens.getToken()),
				"Statement");
		if (Assign.isAssign(tokens.getToken())) {
			body = new Assign();
			body.parse(tokens);
		} else if (If.isIf(tokens.getToken())) {
			body = new If();
			body.parse(tokens);
		} else if (Loop.isLoop(tokens.getToken())) {
			body = new Loop();
			body.parse(tokens);
		} else if (Input.isInput(tokens.getToken())) {
			body = new Input();
			body.parse(tokens);
		} else if (Output.isOutput(tokens.getToken())) {
			body = new Output();
			body.parse(tokens);
		} else
			Reporter.Assert(tokens.hasCurrent() && false, "Statement");
	}

	public void execute() {

	}

	public void print(int tabStop) {
		Tab.print(tabStop);
		body.print(tabStop);
	}

}

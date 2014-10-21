public class Statement implements Production {

	Production body;

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
		if (Assign.isAssign(tokens.getToken()))
			Assign.parse(tokens);
		else if (If.isIf(tokens.getToken()))
			If.parse(tokens);
		else if (Loop.isLoop(tokens.getToken()))
			Loop.parse(tokens);
		else if (Input.isInput(tokens.getToken()))
			Input.parse(tokens);
		else if (Output.isOutput(tokens.getToken()))
			Output.parse(tokens);
		else
			Reporter.Assert(tokens.hasCurrent() && false, "Statement");

		if (tokens.hasCurrent() && isStatement(tokens.getToken()))
			Statement.parse(tokens);
	}

	public void execute() {

	}

	public void print() {

	}

}

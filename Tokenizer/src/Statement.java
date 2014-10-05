import java.util.ArrayList;

public class Statement {

	public static boolean isStatement(String token) {
		boolean result = false;
		result = result || Assign.isAssign(token);
		result = result || If.isIf(token);
		result = result || Loop.isLoop(token);
		result = result || Input.isInput(token);
		result = result || Output.isOutput(token);
		return result;
	}

	public static void parse(Token tokens, ArrayList<Integer> t) {
		Reporter.Assert(tokens.hasCurrent() && isStatement(tokens.current()), "Expected Statement");
		if (Assign.isAssign(tokens.current()))
			Assign.parse(tokens, t);
		else if (If.isIf(tokens.current()))
			If.parse(tokens, t);
		else if (Loop.isLoop(tokens.current()))
			Loop.parse(tokens, t);
		else if (Input.isInput(tokens.current()))
			Input.parse(tokens, t);
		else if (Output.isOutput(tokens.current()))
			Output.parse(tokens, t);
		else
			Reporter.Assert(false, "Expected Statement");

		if (tokens.hasCurrent() && isStatement(tokens.current()))
			Statement.parse(tokens, t);
	}
}

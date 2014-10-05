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

	public static void parse(Symbol tokens) {
		Reporter.Assert(tokens.hasCurrent() && isStatement(tokens.current()), "Statement");
		if (Assign.isAssign(tokens.current()))
			Assign.parse(tokens);
		else if (If.isIf(tokens.current()))
			If.parse(tokens);
		else if (Loop.isLoop(tokens.current()))
			Loop.parse(tokens);
		else if (Input.isInput(tokens.current()))
			Input.parse(tokens);
		else if (Output.isOutput(tokens.current()))
			Output.parse(tokens);
		else
			Reporter.Assert(tokens.hasCurrent() && false, "Statement");

		if (tokens.hasCurrent() && isStatement(tokens.current()))
			Statement.parse(tokens);
	}
}

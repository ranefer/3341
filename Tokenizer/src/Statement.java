import java.util.ArrayList;

public class Statement {

	public static boolean isStatement(String token) {
		boolean result = false;
		for (String s : RESERVED) {
			result = result || token.equals(s);
		}
		return result;
	}

	private static final String[] RESERVED = { "if", "while", "loop", "assign",
			"read", "write" };

	public static void parse(Token tokens, ArrayList<Integer> t) {
		assert (isStatement(tokens.current()));
        if(Assign.isAssign(tokens.current()))
        	Assign.parse(tokens, t);
		else if(If.isIf(tokens.current())) 
			If.parse(tokens, t);
		else if(Loop.isLoop(tokens.current())) 
			Loop.parse(tokens, t);
		else if(Input.isInput(tokens.current())) 
			Input.parse(tokens, t);
		else if(Output.isOutput(tokens.current())) 
			Output.parse(tokens, t);
		else 
			assert(false);

        if(tokens.hasCurrent() && isStatement(tokens.current()))
        	Statement.parse(tokens, t);
	}
}

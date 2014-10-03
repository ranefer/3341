import java.util.ArrayList;


public class StatementSequence {

	public static void parse(Token tokens, ArrayList<Integer> t) {
		
		// there is no way ss is called w/o there being a statemnt
		Statement.parse(tokens, t);
		
		if(StatementSequence.isStatementSequence(tokens.current()))
            StatementSequence.parse(tokens, t);
	}
	
	public static boolean isStatementSequence(String token) {
		return Statement.isStatement(token);
	}
}

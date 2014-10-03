import java.util.ArrayList;


public class If {

	public static void parse(Token tokens, ArrayList<Integer> t) {
	
		assert(tokens.current().equals("if"));
		tokens.skip();
		
		assert(Condition.isCondition(tokens.current())) : "Expected a condition statement";
		Condition.parse(tokens, t);

		parseThen(tokens, t);
		
		if(StatementSequence.isStatementSequence(tokens.current()))
            StatementSequence.parse(tokens, t);
		
		parseElse(tokens, t);
	
		
	}
	
	public static void parseCondition(Token tokens, ArrayList<Integer> t) {
		String openParen = tokens.current();
		assert(openParen.equals("(")) : "Expected: '(' but was " + openParen;

		Condition.parse(tokens, t);

		String closedParen = tokens.current();
		assert(closedParen.equals(")")) : "Expected: ')' but was " + closedParen;

		tokens.skip();
	}
	
	private static void parseThen(Token tokens, ArrayList<Integer> t) {
		String then = "";
		if(tokens.hasNext())
			then = tokens.current();
		assert(then.equals("then")) : "Expected 'then' but was " + then;
		
		tokens.skip();
	}
	private static void parseElse(Token tokens, ArrayList<Integer> t) {
		if(tokens.hasNext()) {
			if(tokens.current().equals("else")) {
				tokens.next();
                if(StatementSequence.isStatementSequence(tokens.current()))
                	Statement.parse(tokens, t);
			}
		}
	}
	
		
	private static void parseEnd(Token tokens, ArrayList<Integer> t) {
		String end = "";
		if(tokens.hasNext())
			end = tokens.current();
		assert(end.equals("end")) : "Expected 'end' but was " + end;
		
		tokens.skip();
	}
}

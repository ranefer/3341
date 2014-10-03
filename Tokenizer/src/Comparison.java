import java.io.BufferedReader;
import java.util.ArrayList;

public class Comparison {

	public static void parse(Token tokens, ArrayList<Integer> t) {
		parseOpenParen(tokens, t);
		
		parseCompareOperator(tokens, t);
		
		parseClosedParen(tokens, t);
	}

	public static boolean isComparison(String token) {
		return token.equals("(");
	}

	private static void parseOpenParen(Token tokens, ArrayList<Integer> t) {
		String openParen = "";
		if(tokens.hasNext())
			openParen = tokens.current();
		assert(openParen.equals("(")) : "Expected '(' but was " + openParen;
		
		tokens.skip();
	}
	
	private static void parseCompareOperator(Token tokens, ArrayList<Integer> t) {
		if(tokens.hasNext()) {
			switch(tokens.current()) {
 	        case "!=":
 	        	t.add(25);
 	        	break;
            case "==":
            	t.add(26);
            	break;
            case "<":
                 t.add(27);
                 break;
            case ">":
                 t.add(28);
                 break;
            case "<=":
            	t.add(29);
            	break;
            case ">=":
            	t.add(30);
            	break;
            default:
            	assert(false) : "Exptected a comparision but was " + tokens.current();
			}
		} else
            assert(false) : "Exptected a comparision but was " + tokens.current();

		tokens.skip();
	}
	
    private static void parseClosedParen(Token tokens, ArrayList<Integer> t) {
		String closedParen = "";
		if(tokens.hasNext())
			closedParen = tokens.current();
		assert(closedParen.equals("(")) : "Expected '(' but was " + closedParen;
		
		tokens.skip();	
	}
}


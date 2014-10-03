import java.util.ArrayList;

public class Expression {

	public static boolean isExpression (String token){
		return Factor.isFactor(token);
	}

	public static void parse(Token tokens, ArrayList<Integer> t) {
		assert(isExpression(tokens.current()));
		
		Factor.parse(tokens, t);
		
		if(tokens.hasCurrent() && tokens.current().equals("+")) {
			t.add(22);
        	assert(tokens.hasNext() && Expression.isExpression(tokens.current()));
        	Expression.parse(tokens, t);
		} else if(tokens.hasCurrent() && tokens.current().equals("-")) {
			t.add(23);
            assert(tokens.hasNext() && Expression.isExpression(tokens.current()));
            Expression.parse(tokens, t);
		} else 
			assert(false) : "Expected +/-";
	}
}

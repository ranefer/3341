import java.util.ArrayList;

public class Tokens {
	private static ArrayList<Integer> tokens = new ArrayList<Integer>();
	
	public static void add(int token) {
		tokens.add(token);
	}
	
	public static String toTokenString() {
		String result = "";
        for(int i = 0; i < tokens.size(); i++){
			result += tokens.get(i) + " ";
		}
        return result;
	}
}

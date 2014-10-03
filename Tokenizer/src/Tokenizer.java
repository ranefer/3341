import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Tokenizer {

	public static void main(String ...args) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		System.out.println(args.toString());
		Token tokens = new Token(args);
		
		Program.parse(tokens, result);
		System.out.println(result.toString());
		
	}
}

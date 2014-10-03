import java.util.ArrayList;

public class Tokenizer {

	public static void main(String... args) {

		ArrayList<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < args.length; i++) {
			System.out.println(args[i]);
		}
		System.out.println(args.length);
		Token tokens = new Token(args);

		Program.parse(tokens, result);
		System.out.println(result.toString());

	}
}

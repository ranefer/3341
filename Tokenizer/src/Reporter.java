
public class Reporter {

	public static void Assert(boolean b, String error) {
		if (b)
			return;
		System.out.println(Tokenizer.result.toString());

		System.out.println(error);
		System.exit(10);
	}
}

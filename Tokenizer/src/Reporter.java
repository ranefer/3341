
public class Reporter {

	public static void Assert(boolean b, String error) {
		if (b)
			return;
		Report();
		System.out.println();
		System.out.println(error);
		System.exit(10);
	}
	
	public static void Report() {
		for(int i = 0; i < Tokenizer.result.size(); i++){
			System.out.print(Tokenizer.result.get(i) + " ");
		}
	}
}

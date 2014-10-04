import java.util.ArrayList;

public class Tokenizer {

	public static void main(String... args) {
		ArrayList<String> ARGS = new ArrayList<String>();
		ArrayList<Integer> result = new ArrayList<Integer>();
		String temp = "";
		for (int i = 0; i < args.length; i++) {
			args[i]= args[i].replaceAll(";", " ; ");
			args[i]= args[i].replaceAll("===", " == = ");
			args[i]= args[i].replaceAll("==", " == ");
			args[i]= args[i].replaceAll("[\\(]", " ( ");
			args[i]= args[i].replaceAll("[\\)]", " ) ");
			args[i]= args[i].replaceAll("[\\[]", " [ ");
			args[i]= args[i].replaceAll("[\\]]", " ] ");

			if(args[i].matches("[A-Z]+[0-9]*[\\s]*[=][\\s]*[0-9]+[\\s]*[;][\\s]*"))
                args[i]= args[i].replaceAll("[=]", " = ");
			args[i]= args[i].replaceAll("[\\]]", " ] ");
		}
		for(int i = 0; i < args.length; i++) {
			String[] temp1 = args[i].split(" ");
			for(int j = 0; j < temp1.length; j++){
				ARGS.add(temp1[j]);
			}
		}
		Token tokens = new Token(ARGS);

		Program.parse(tokens, result);

		System.out.println(result.toString());
	}
}

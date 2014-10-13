import java.util.ArrayList;

public class Tokenizer {

	public static void main(String... args) {
		ArrayList<String> ARGS = new ArrayList<String>();
		String temp = "";
		for (int i = 0; i < args.length; i++) {
			args[i] = args[i].replaceAll("[\\(]", " ( ");
			args[i] = args[i].replaceAll("[\\)]", " ) ");
			args[i] = args[i].replaceAll("[\\[]", " [ ");
			args[i] = args[i].replaceAll("[\\]]", " ] ");

			args[i] = args[i].replaceAll(";", " ; ");
			args[i] = args[i].replaceAll(",", " , ");
			args[i] = args[i].replaceAll("=", " = ");
		}
		for (int i = 0; i < args.length; i++) {
			String[] temp1 = args[i].split("[\\s]+");
			for (int j = 0; j < temp1.length; j++) {
				if (!temp1[j].equals("")) {
					temp1[j] = temp1[j].replaceAll("[A-Z]+[0-9]*",
							"_IDENTIFIER");
					temp1[j] = temp1[j].replaceAll("[0-9]+", "_INTEGER");
					ARGS.add(temp1[j]);
				}
			}
		}
		Tokens tokens = new Tokens(new Symbol(ARGS));

		while (tokens.hasNext()) {
			System.out.print(tokens.getNext() + " ");
		}
	}
}

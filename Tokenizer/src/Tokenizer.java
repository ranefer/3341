import java.util.ArrayList;
import java.util.Scanner;

public class Tokenizer {

	public static void main(String... args) {
		ArrayList<String> redirectedArgs = new ArrayList<String>();
		Scanner scanner = new Scanner(System.in);
		if (args.length == 0) {
			while (scanner.hasNext())
				redirectedArgs.add(scanner.next());
			args = new String[redirectedArgs.size()];
			for (int i = 0; i < args.length; i++) {
				args[i] = redirectedArgs.get(i);
			}
		}

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
				ARGS.add(temp1[j]);
				}
			}
		}
		Symbol symbols = new Symbol(ARGS);
		Tokens tokens = new Tokens(symbols);
		Program p = new Program();
		Reporter.setSymbols(symbols);
		/*
		 * while (tokens.hasCurrent()) { System.out.print(tokens.getToken() +
		 * " "); tokens.skip(); }
		 */
		tokens.reset();
		p.parse(tokens);
		p.print(0);
	}
}

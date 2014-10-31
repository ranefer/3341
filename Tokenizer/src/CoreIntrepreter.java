import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class CoreIntrepreter {

	public static void main(String... args) {

		String[] source = null;
		String[] data = null;
		if (args.length == 0) {
			args = getArgs();
			source = read(args[0]);
		} else {
			source = read(args[0]);

			try {
				Data.setData(new Scanner(new FileReader(args[1])));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		ArrayList<String> ARGS = new ArrayList<String>();
		String temp = "";
		for (int i = 0; i < source.length; i++) {
			source[i] = source[i].replaceAll("[\\(]", " ( ");
			source[i] = source[i].replaceAll("[\\)]", " ) ");
			source[i] = source[i].replaceAll("[\\[]", " [ ");
			source[i] = source[i].replaceAll("[\\]]", " ] ");

			source[i] = source[i].replaceAll("[\\*]", " * ");
			source[i] = source[i].replaceAll("[\\-]", " - ");
			source[i] = source[i].replaceAll("[\\+]", " + ");

			source[i] = source[i].replaceAll("!", " ! ");
			source[i] = source[i].replaceAll(";", " ; ");
			source[i] = source[i].replaceAll(">", " > ");
			source[i] = source[i].replaceAll("<", " < ");
			source[i] = source[i].replaceAll(",", " , ");
			source[i] = source[i].replaceAll("=", " = ");
		}
		for (int i = 0; i < source.length; i++) {
			String[] temp1 = source[i].split("[\\s]+");
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
		System.out.println();
		p.execute();
	}

	public static String[] getArgs() {
		ArrayList<String> redirectedArgs = new ArrayList<String>();
		Scanner scanner = new Scanner(System.in);

		while (scanner.hasNext())
			redirectedArgs.add(scanner.next());

		String[] result = new String[redirectedArgs.size()];
		for (int i = 0; i < result.length; i++) {
			result[i] = redirectedArgs.get(i);
		}
		return result;

	}

	public static String[] read(String file) {
		String[] result = null;
		ArrayList<String> temp = new ArrayList<String>();
		try {
			Scanner scanner = new Scanner(new FileReader(file));
			while (scanner.hasNext())
				temp.add(scanner.next());
			scanner.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

		}
		result = new String[temp.size()];
		for (int i = 0; i < temp.size(); i++) {
			result[i] = temp.get(i);
		}
		return result;
	}
}

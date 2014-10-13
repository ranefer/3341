import java.util.ArrayList;

public class Tokenizer {

	public static void main(String... args) {
		ArrayList<String> ARGS = new ArrayList<String>();
		String temp = "";
		for (int i = 0; i < args.length; i++) {

			args[i] = args[i].replaceAll(";", " ; ");
			args[i] = args[i].replaceAll(",", " , ");
			args[i] = args[i].replaceAll("!", " ! ");
			args[i] = args[i].replaceAll("[\\[]", " [ ");
			args[i] = args[i].replaceAll("[\\]]", " ] ");
			args[i] = args[i].replaceAll("[&][&]", " && ");
			args[i] = args[i].replaceAll("[|][|]", " || ");
			args[i] = args[i].replaceAll("[\\(]", " ( ");
			args[i] = args[i].replaceAll("[\\)]", " ) ");
			args[i] = args[i].replaceAll("\\+", " + ");
			args[i] = args[i].replaceAll("\\-", " - ");
			args[i] = args[i].replaceAll("\\*", " * ");
			args[i] = args[i].replaceAll("\\!", " ! ");
			args[i] = args[i].replaceAll("=", " = ");
			args[i] = args[i].replaceAll("<", " < ");
			args[i] = args[i].replaceAll(">", " > ");
			args[i] = args[i].replaceAll("[\\]]", " ] ");

			if (args[i].matches("[\\s]+(if)[\\s]+"))
				args[i] = args[i].replaceAll("if", " if ");
			if (args[i].matches("[\\s]+(then)[\\s]+"))
				args[i] = args[i].replaceAll("then", " then ");
			if (args[i].matches("[\\s]+(else)[\\s]+"))
				args[i] = args[i].replaceAll("else", " else ");
			if (args[i].matches("[\\s]+(while)[\\s]+"))
				args[i] = args[i].replaceAll("while", " while ");
			if (args[i].matches("[\\s]+(loop)[\\s]+"))
				args[i] = args[i].replaceAll("loop", " loop ");
			if (args[i].matches("[\\s]+(read)[\\s]+"))
				args[i] = args[i].replaceAll("read", " read ");
			if (args[i].matches("[\\s]+(write)[\\s]+"))
				args[i] = args[i].replaceAll("write", " write ");

		}

		for (int i = 0; i < args.length; i++) {
			args[i].matches("[=]");
			String[] temp1 = args[i].split("[\\s]+");
			for (int j = 0; j < temp1.length; j++) {
				if (!temp1[j].equals("")) {
					if (temp1[j].matches("[0-9]+")
							&& !temp1[j].matches("[A-Z]+[0-9]*"))
						temp1[j] = temp1[j].replaceAll("[0-9]+", "31");

					temp1[j] = temp1[j].replaceAll("[A-Z]+[0-9]*", "32");
					temp1[j] = temp1[j].replaceAll("program", "1");
					temp1[j] = temp1[j].replaceAll("begin", "2");
					temp1[j] = temp1[j].replaceAll("end", "3");
					temp1[j] = temp1[j].replaceAll("int", "4");
					temp1[j] = temp1[j].replaceAll("if", "5");
					temp1[j] = temp1[j].replaceAll("then", "6");
					temp1[j] = temp1[j].replaceAll("else", "7");
					temp1[j] = temp1[j].replaceAll("while", "8");
					temp1[j] = temp1[j].replaceAll("loop", "9");
					temp1[j] = temp1[j].replaceAll("read", "10");
					temp1[j] = temp1[j].replaceAll("write", "11");
					temp1[j] = temp1[j].replaceAll(";", "12");
					temp1[j] = temp1[j].replaceAll(",", "13");
					temp1[j] = temp1[j].replaceAll("[\\[]", "16");
					temp1[j] = temp1[j].replaceAll("[\\]]", "17");
					temp1[j] = temp1[j].replaceAll("([&][&])", "18");
					temp1[j] = temp1[j].replaceAll("[|][|]", "19");
					temp1[j] = temp1[j].replaceAll("[\\(]", "20");
					temp1[j] = temp1[j].replaceAll("[\\)]", "21");
					temp1[j] = temp1[j].replaceAll("\\+", "22");
					temp1[j] = temp1[j].replaceAll("\\-", "23");
					temp1[j] = temp1[j].replaceAll("\\*", "24");
					temp1[j] = temp1[j].replaceAll("=", "=");

					ARGS.add(temp1[j]);
				}
			}
		}
		for (int i = 0; i < ARGS.size(); i++) {
			boolean addedToken = false;
			int len = Tokens.toTokenString().length();
			try {
				Tokens.add(Integer.valueOf(ARGS.get(i)));
			} catch (NumberFormatException e) {
				String first = ARGS.get(i);
				String second = ARGS.get(i + 1);

				if (i + 1 < ARGS.size()) {

					addedToken = tokTwo(first, second);
					addedToken = !addedToken ? tokOne(first) : addedToken;
				} else {
					tokOne(first);
				}

				if (!addedToken) {
					Reporter.Report();
					System.out.println("ERROR");
					System.exit(10);
				}
			}
		}
		Reporter.Report();

	}

	private static boolean tokTwo(String first, String second) {
		int len = Tokens.toTokenString().length();
		if (second.equals("=")) {
			if (first.equals("="))
				Tokens.add(26);
			else
				Tokens.add(14);
			if (first.equals("<"))
				Tokens.add(29);
			else
				Tokens.add(27);
			if (first.equals(">"))
				Tokens.add(30);
			else
				Tokens.add(28);
			if (first.equals("!"))
				Tokens.add(25);
			else
				Tokens.add(15);
		}
		return len < Tokens.toTokenString().length();
	}

	public static boolean tokOne(String first) {
		int len = Tokens.toTokenString().length();
		if (first.equals("="))
			Tokens.add(14);
		if (first.equals("!"))
			Tokens.add(15);
		if (first.equals("<"))
			Tokens.add(27);
		if (first.equals(">"))
			Tokens.add(28);
		return len < Tokens.toTokenString().length();
	}

}

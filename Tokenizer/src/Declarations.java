import java.util.ArrayList;

public class Declarations {

	public static boolean isDeclaration(String token) {
		return token.equals("int");
	}

	public static void parse(Token tokens, ArrayList<Integer> t) {
		assert (isDeclaration(tokens.current()));
		tokens.skip();

		parseInt(tokens, t);
		parseId(tokens, t);
		parseColon(tokens, t);

		if (tokens.current().equals("int")) {
			Declarations.parse(tokens, t);
		}
	}

	private static void parseInt(Token tokens, ArrayList<Integer> t) {
		String keyword = "";
		if (tokens.hasNext())
			keyword = tokens.current();
		assert (keyword.equals("int")) : "Expected: int but was " + keyword;

		t.add(4); // int

		tokens.skip();
	}

	private static void parseId(Token tokens, ArrayList<Integer> t) {
		String id = "";
		if (tokens.hasNext())
			id = tokens.current();
		assert (id.matches("[A-Z]+")) : "Delcaration id's must be capitalized, "
				+ id + " is not a valid id";

		t.add(18); // id

		tokens.skip();

		if (tokens.current().equals(","))
			parseId(tokens, t);

	}

	private static void parseColon(Token tokens, ArrayList<Integer> t) {

		String semiColon = "";
		if (tokens.hasNext())
			semiColon = tokens.current();
		assert (semiColon.equals(";")) : "Expected: ';' but was " + semiColon;

		t.add(12); // ;

		tokens.skip();
	}
}

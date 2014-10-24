import java.util.Hashtable;

public class Id implements Production {

	String name;
	
	private static Hashtable<String, Set<Integer, Boolean, Boolean>> variables = new Hashtable<String, Set<Integer, Boolean, Boolean>>();
	
	boolean isDeclared = false;
	
	public Id() {
	}

	public static boolean isId(int token) {
		return token == 32;
	}

	public void parse(Tokens tokens) {
		Reporter.Assert(tokens.hasCurrent() && isId(tokens.getToken()), "Id");

		String key = tokens.getSymbol();
		name = key;
		Set value = new Set(0,isDeclared,false);

		variables.put(key, value);
		tokens.skip();
	}

	public void execute() {
		System.out.println(name + " =  " + variables.get(name).first);
	}

	public void print(int tabStop) {
		System.out.print(name);
	}
	
	public int getValue() {
		return variables.get(name).first;
	}
	public void setValue(int value) {
		variables.get(name).first = value;
	}
	
	public static boolean isDeclared(String name){
		return variables.containsKey(name);
	}
}

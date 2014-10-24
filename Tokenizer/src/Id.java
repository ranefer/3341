import java.util.Hashtable;

public class Id implements NumericProduction{

	String name;
	
	private static Hashtable<String, VariableInfo<Integer, Boolean, Boolean>> variables = new Hashtable<String, VariableInfo<Integer, Boolean, Boolean>>();
	
	public static boolean isId(int token) {
		return token == 32;
	}

	public void parse(Tokens tokens) {
		Reporter.Assert(tokens.hasCurrent() && isId(tokens.getToken()), "Id");

		String key = tokens.getSymbol();
		name = key;
		VariableInfo value = new VariableInfo(0,true,false);

		variables.put(key, value);
		tokens.skip();
	}

	public void print(int tabStop) {
		System.out.print(name);
	}
	
	public void setValue(int value) {
		variables.get(name).isInit = true;
		variables.get(name).value = value;
	}
	
	public static boolean isDeclared(String name){
		return variables.containsKey(name);
	}

	@Override
	public int value() {
		return variables.get(name).value;
	}
}

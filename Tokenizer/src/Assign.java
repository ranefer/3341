public class Assign implements Production {

	Production id;
	Production expr;

	public Assign() {
		id = new Id();
		expr = new Expression();
	}

	public static boolean isAssign(int token) {
		return Id.isId(token); // assign { id = expression }
	}

	public void parse(Tokens tokens) {
		Reporter.Assert(tokens.hasCurrent() && isAssign(tokens.getToken()),
				"Id");
		String sym = tokens.getSymbol();
		Reporter.Assert(Id.isDeclared(tokens.getSymbol()), "declared identifier");
		id.parse(tokens);

		parseEqualSign(tokens);

		expr.parse(tokens);

		SemiColon.parse(tokens);
	}

	public void execute() {

	}

	public void print(int tabStop) {
		id.print(tabStop);
		System.out.print(" = ");
		expr.print(tabStop);
		System.out.println(";");
	}

	private void parseEqualSign(Tokens tokens) {
		Reporter.Assert(tokens.hasCurrent() && tokens.getToken() == 14, "=");
		tokens.skip();
	}

}

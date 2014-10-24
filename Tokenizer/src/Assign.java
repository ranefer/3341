public class Assign implements Production {

	Id id;
	Expression expr;

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
		Reporter.Assert(Id.isDeclared(tokens.getSymbol()), "declared identifier");
		id.parse(tokens);

		parseEqualSign(tokens);

		expr.parse(tokens);

		SemiColon.parse(tokens);
	}

	public void execute() {
		id.setValue(expr.value());
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

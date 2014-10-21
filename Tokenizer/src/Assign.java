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
		id.parse(tokens);

		parseEqualSign(tokens);

		expr.parse(tokens);

		Reporter.Assert(
				tokens.hasCurrent() && SemiColon.isSemiColon(tokens.getToken()),
				";");
		tokens.skip();
	}

	public void execute() {

	}

	public void print() {
		id.print();
		System.out.print(" = ");
		expr.print();
		System.out.print(";");
	}

	private void parseEqualSign(Tokens tokens) {
		Reporter.Assert(tokens.hasCurrent() && tokens.getToken() == 14, "=");
		tokens.skip();
	}

}

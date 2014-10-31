public interface BooleanProduction {
	public void parse(Tokens tokens);

	public void print(int tabStop);

	public boolean evaluate();
}

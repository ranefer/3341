public interface Production {
	public void parse(Tokens tokens);

	public void print(int tabStop);
	
	public void execute();
}
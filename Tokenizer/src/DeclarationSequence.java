
public class DeclarationSequence implements Production {
	
	Declarations declaration;
	
	DeclarationSequence ds;
	
	public DeclarationSequence() {
		declaration = new Declarations();
	}

	public static boolean isDeclarationSequence(int i) {
		return Declarations.isDeclaration(i);
	}

	@Override
	public void parse(Tokens tokens) {
		Reporter.Assert(
				tokens.hasCurrent() && isDeclarationSequence(tokens.getToken()),
				"int");
		declaration.parse(tokens);
		if(isDeclarationSequence(tokens.getToken())) {
			ds= new DeclarationSequence();
            ds.parse(tokens);
		}
	}

	@Override
	public void print(int tabStop) {
		declaration.print(tabStop);
		if(ds != null)
			ds.print(tabStop);
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}
}

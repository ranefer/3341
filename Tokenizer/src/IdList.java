
public class IdList implements Production {
	Id id;
	IdList idList;

	public IdList() {
		id = new Id();
	}

	@Override
	public void parse(Tokens tokens) {
		Reporter.Assert(tokens.hasCurrent() && Id.isId(tokens.getToken()), "identifier");
		id.parse(tokens);
		if(Comma.isComma(tokens.getToken())) {
			tokens.skip();
			idList = new IdList();
			idList.parse(tokens);
		}
		
	}

	public void execute() {
	}

	@Override
	public void print(int tabStop) {
		id.print(tabStop);
		if(idList!= null) {
			System.out.print(", ");
			idList.print(tabStop);
		}
		
	}
	
	
}

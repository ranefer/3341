
public class VariableInfo<T1, T2, T3> {
	T1 value;
	T2 isDeclared;
	T3 isInit;
	public VariableInfo(T1 first, T2 second, T3 third) {
		this.value= first;
		this.isDeclared = second;
		this.isInit = third;
	}
}

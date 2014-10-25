import java.io.Reader;
import java.util.ArrayList;
import java.util.Scanner;
public class Data {

	private static Data data = new Data();
	private static Scanner args;

	private Data() {
	}

	public static Data getInstance() {
		return data;
	}

	public static String next() {
		return args.next();
	}
	
	public static void setData(Scanner data) {
		args = data;
	}
}

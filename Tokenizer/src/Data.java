import java.util.NoSuchElementException;
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
		String result = null;
		try {
			result = args.next();
			Integer.valueOf(result);
		} catch (NoSuchElementException e) {
			Reporter.Exit("No more data in input stream");
		} catch (Exception e) {
			Reporter.Assert(false, "integer value");
		}
		return result;
	}

	public static void setData(Scanner data) {
		args = data;
	}
}

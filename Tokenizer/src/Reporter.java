import java.util.ArrayList;

public class Reporter {

	public static void Assert(boolean b, String error, ArrayList<Integer> t) {
		if (b)
			return;
		System.out.println(t.toString());

		System.out.println(error);
		System.exit(10);
	}
}

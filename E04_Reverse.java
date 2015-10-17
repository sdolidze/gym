import java.util.*;

public class E04_Reverse {
	public static void main(String[] args) {
		System.out.println(Arrays.asList(
			reverse("san").equals("nas"),
			reverse("sas").equals("sas"),
			reverse("a").equals("a"),
			reverse("").equals(""),
			reverse("as").equals("sa")
		));
	} 

	public static String reverse(String str) {
		if (str == null) {
			throw new IllegalArgumentException("string cannot be null");
		}
		char[] xs = str.toCharArray();
		for (int i = 0; i < xs.length / 2; i++) {
			swap(xs, i, xs.length - 1 - i);
		}
		return new String(xs);
	}

	public static void swap(char[] xs, int i, int j) {
		char temp = xs[i];
		xs[i] = xs[j];
		xs[j] = temp;
	}
}
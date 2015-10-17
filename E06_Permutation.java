import java.util.*;

public class E06_Permutation {
	public static void main(String[] args) {
		System.out.println(Arrays.asList(
			isPermutation("sandro", "ordnas"),
			!isPermutation("sandro", "dolidze"),
			isPermutation("a", "a"),
			isPermutation("", "")
		));

			System.out.println(Arrays.asList(
				isPermutation2("sandro", "ordnas"),
				!isPermutation2("sandro", "dolidze"),
				isPermutation2("a", "a"),
				isPermutation2("", "")
		));
	}

	public static boolean isPermutation(String one, String two) {
		char[] xs = one.toCharArray();
		Arrays.sort(xs);

		char[] ys = two.toCharArray();
		Arrays.sort(ys);

		return Arrays.equals(xs, ys);
	}

	public static boolean isPermutation2(String one, String two) {
		return frequencies(one).equals(frequencies(two));
	}

	public static Map<Character, Integer> frequencies(String one) {
		Map<Character, Integer> map = new HashMap<>();

		for (char x: one.toCharArray()) {
			map.put(x, map.getOrDefault(x, 0));
		}

		return map;
	}
}

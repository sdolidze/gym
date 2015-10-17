import java.util.*;

public class E05_UniqueCharacters {
	public static void main(String[] args) {
		System.out.println(Arrays.asList(
			hasUniqueCharacters("sandro"),
			!hasUniqueCharacters("aba"),
			hasUniqueCharacters("a"),
			hasUniqueCharacters("")
		));

		System.out.println(Arrays.asList(
			hasUniqueCharacters2("sandro"),
			!hasUniqueCharacters2("aba"),
			hasUniqueCharacters2("a"),
			hasUniqueCharacters2("")
		));
	}

	public static boolean hasUniqueCharacters(String xs) {
		Set<Character> set = new HashSet<>();

		for (char x: xs.toCharArray()) {
			set.add(x);
		}

		return set.size() == xs.length();
	}

	public static boolean hasUniqueCharacters2(String str) {
		char[] xs = str.toCharArray();
		Arrays.sort(xs);
		
		for (int i = 1; i < xs.length; i++) {
			if (xs[i - 1] == xs[i]) {
				return false;
			} 
		}

		return true;
	}
}

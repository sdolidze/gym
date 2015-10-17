import java.util.*;
import java.util.function.*;

public class E13_AnagaramSort {
	public static void main(String[] args) {
		java.util.List<String> xs = Arrays.asList("as", "san", "sa", "nas", "j");
		java.util.List<String> exp = Arrays.asList("san", "nas", "as", "sa", "j");
		System.out.println(anagramSort(xs).equals(exp));
		System.out.println(anagramSort2(xs).equals(exp));
	}

	private static Comparator<String> anagramComparator = new Comparator<String>() {
		@Override
		public int compare(String one, String two) {
			return sort(one).compareTo(sort(two));
		}
	};

	public static java.util.List<String> anagramSort(java.util.List<String> xs) {
		Map<String, java.util.List<String>> map = groupBy(E13_AnagaramSort::sort, xs);
		java.util.List<String> res = new ArrayList<>();

		for (java.util.List<String> anagrams: map.values()) {
			res.addAll(anagrams);
		}

		return res;
	}

	public static java.util.List<String> anagramSort2(java.util.List<String> xs) {
		ArrayList<String> copy = new ArrayList<>(xs);
		Collections.sort(copy, anagramComparator);
		return copy;
	}

	public static String sort(String str) {
		char[] xs = str.toCharArray();
		Arrays.sort(xs);
		return new String(xs);
	}

	public static<A, B> Map<B, java.util.List<A>> groupBy(Function<A, B> fn, java.util.List<A> xs) {
		Map<B, java.util.List<A>> map = new TreeMap<>();

		for (A x: xs) {
			B key = fn.apply(x);
			java.util.List<A> ys = map.getOrDefault(key, new ArrayList<>());
			ys.add(x);
			map.put(key, ys);
		}

		return map;
	}
}

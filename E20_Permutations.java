import java.util.*;

public class E20_Permutations {
	public static void main(String[] args) {
		java.util.List<Integer> xs = new ArrayList<>(Arrays.asList(1, 2, 3));
		System.out.println(permutations(xs));
	}

	public static<T> java.util.List<java.util.List<T>> permutations(java.util.List<T> xs) {
		if (xs.isEmpty()) {
			java.util.List<java.util.List<T>> xss = new ArrayList<>();
			xss.add(new ArrayList<>());
			return xss;
		}

		T item = xs.remove(0);

		java.util.List<java.util.List<T>> xss = new ArrayList<>();

		for (java.util.List<T> ys: permutations(xs)) {
			for (int i = 0; i <= ys.size(); i++) {
				xss.add(insert(ys, item, i));
			}
		}

		return xss;
	}

	public static<T> java.util.List<T> insert(java.util.List<T> xs, T x, int pos) {
		java.util.List<T> copy = new java.util.ArrayList<T>(xs);
		copy.add(pos, x);
		return copy;
	}
}

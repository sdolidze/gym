import java.util.*;

public class E19_Powerset {
	public static void main(String[] args) {
		Set<Integer> set = new HashSet<>(Arrays.asList(1, 2, 3));
		System.out.println(powerset(set));
	}

	public static<T> Set<Set<T>> powerset(Set<T> set) {
		if (set.isEmpty()) {
			return new HashSet<>(Arrays.asList(set));
		}

		T item = set.iterator().next();
		set.remove(item);

		Set<Set<T>> res = powerset(set);

		for (Set<T> xs: new HashSet<>(res)) {
			Set<T> ys = new HashSet<>(xs);
			ys.add(item);
			res.add(ys);
		}

		return res;
	}
}

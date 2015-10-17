import java.util.*;

public class E07_RemoveDuplicates {
	public static void main(String[] args) {
		System.out.println(Arrays.asList(
			List.equals(removeDuplicates(List.of()), List.of()),
			List.equals(removeDuplicates(List.of(1, 1, 2)), List.of(1, 2)),
			List.equals(removeDuplicates(List.of(1, 1, 1)), List.of(1)),
			List.equals(removeDuplicates(List.of(1, 2, 3)), List.of(1, 2, 3))
		));

		System.out.println(Arrays.asList(
			List.equals(removeDuplicates2(List.of()), List.of()),
			List.equals(removeDuplicates2(List.of(1, 1, 2)), List.of(1, 2)),
			List.equals(removeDuplicates2(List.of(1, 1, 1)), List.of(1)),
			List.equals(removeDuplicates2(List.of(1, 2, 3)), List.of(1, 2, 3))
		));
	}

	public static List removeDuplicates(List xs) {
		Set<Integer> set = new HashSet<>();

		List sentinel = new List(-1, xs);

		List prev = sentinel;
		List cur = sentinel.next;

		while (cur != null) {
			if (set.contains(cur.elem)) {
				prev.next = cur.next;
			} else {
				set.add(cur.elem);
				prev = cur;
			}

			cur = cur.next;
		}

		return sentinel.next;
	}

	public static List removeDuplicates2(List xs) {
		for (List cur = xs; cur != null; cur = cur.next) {
			cur.next = remove(cur.next, cur.elem);
		}

		return xs;
	}

	public static List remove(List xs, int elem) {
		List sentinel = new List(-1, xs);

		List prev = sentinel;
		List cur = sentinel.next;

		while (cur != null) {
			if (cur.elem == elem) {
				prev.next = cur.next;
			} else {
				prev = cur;
			}
			cur = cur.next;
		}

		return sentinel.next;
	}
}

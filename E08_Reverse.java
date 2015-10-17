import java.util.*;

public class E08_Reverse {
	public static void main(String[] args) {
		System.out.println(Arrays.asList(
			List.equals(reverse(List.of(1, 2, 3)), List.of(3, 2, 1)),
			List.equals(reverse(List.of(1, 2)), List.of(2, 1)),
			List.equals(reverse(List.of(1)), List.of(1)),
			List.equals(reverse(List.of()), List.of())
		));
	}

	public static List reverse(List oldList) {
		List newList = null;

		while (oldList != null) {
			// remove from old
			List cur = oldList;
			oldList = oldList.next;

			// add to new
			cur.next = newList;
			newList = cur;
		}

		return newList;
	}
}

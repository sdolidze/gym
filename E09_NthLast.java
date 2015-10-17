import java.util.*;


public class E09_NthLast {
	public static void main(String[] args) {
		System.out.println(Arrays.asList(
			nth(0, List.of(1, 2, 3)) == 1,
			nth(1, List.of(1, 2, 3)) == 2,
			nth(1, List.of(2, 1)) == 1
		));

		System.out.println(Arrays.asList(
			nth2(0, List.of(1, 2, 3)) == 1,
			nth2(1, List.of(1, 2, 3)) == 2,
			nth2(1, List.of(2, 1)) == 1
		));

		System.out.println(Arrays.asList(
			nthLast(0, List.of(1, 2, 3)) == 3,
			nthLast(1, List.of(1, 2, 3)) == 2,
			nthLast(1, List.of(2, 1)) == 2
		));
	}

	public static int nth(int n, List xs) {
		return n == 0 ? xs.elem : nth(n - 1, xs.next);
	}

	public static int nth2(int n, List xs) {
		while (n != 0) {
			n = n - 1;
			xs = xs.next;
		}

		return xs.elem;
	}

	public static int length(List xs) {
		return xs == null ? 0 : 1 + length(xs.next);
	}

	public static int length2(List xs) {
		int length = 0;
		
		for (List cur = xs; cur != null; cur = cur.next) {
			length++;
		}

		return length;
	}

	public static int nthLast(int n, List xs) {
		return nth(length(xs) - 1 - n, xs);
	}
}

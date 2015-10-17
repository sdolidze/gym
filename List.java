public class List {
	public int elem;
	public List next;

	public List(int elem, List next) {
		this.elem = elem;
		this.next = next;
	}

	public static List of(Integer... xs) {
		List head = null;

		for (int i = xs.length - 1; i >= 0; i--) {
			head = new List(xs[i], head); 
		}
	
		return head;
	}

	public static boolean equals(List xs, List ys) {
		if (xs == null && ys == null) {
			return true;
			}
		if (xs == null || ys == null) {
			return false;
		}

		return xs.elem == ys.elem && equals(xs.next, ys.next);
	}

	public static void print(List xs) {
		for (List cur = xs; cur != null; cur = cur.next) {
			System.out.print("" + cur.elem + " ");
		}

		System.out.println();
	}
}
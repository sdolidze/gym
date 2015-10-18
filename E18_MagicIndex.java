import java.util.*;

public class E18_MagicIndex {

	public static void main(String[] args) {
		int[] xs = {-2, -1, 0, 1, 3, 5, 6};
		System.out.println(magicIndex2(xs) == 5);
	}

	public static int magicIndex(int[] xs) {
		int lo = 0;
		int hi = xs.length - 1;

		while (lo <= hi) {
			int mid = (lo + hi) / 2;

			if (xs[mid] < mid) {
				lo = mid + 1;
			} else if (xs[mid] > mid) {
				hi = mid - 1;
			} else /* xs[mid] == mid */ {
				return mid;
			}
		}

		return -1;
	}

	public static int magicIndex2(int[] xs) {
		for (int i = 0; i < xs.length; i++) {
			if (xs[i] == i) {
				return i;
			}
		}

		return -1;
	}
}

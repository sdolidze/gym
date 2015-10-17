import java.util.*;

public class E03_BinarySearch {
	public static void main(String[] args) {
		int[] xs = {1, 2, 3};
		int x = 3;

		int[] ys = {3, 2, 1};
		int y = 2;

		int[] zs = {2, 1, 3};
		int z = 1;

		System.out.println(Arrays.asList(
			binarySearch(xs, x) == 2,
			binarySearch(ys, y) == 1,
			binarySearch(zs, z) == 1
		));
	}

	public static boolean binarySearchProperty(int[] xs, int x) {
		return binarySearch(xs, x) == linearSearch(xs, x);
	}

	public static int linearSearch(int[] xs, int elem) {
		for (int i = 0; i < xs.length; i++) {
			if (xs[i] == elem) {
				return i;
			}
		}
		return -1;
	}

	public static int binarySearch(int[] xs, int elem) {
		int lo = 0;
		int hi = xs.length - 1;

		while (lo <= hi) {
			int mid = (lo + hi) / 2; // same as lo + (hi - lo) / 2
			if (xs[mid] < elem) {
				lo = mid + 1;
			} else if (xs[mid] > elem) {
				hi = mid - 1;
			} else /* xs[mid] == elem */ {
				return mid;
			}
		}

		return -1;
	}
}
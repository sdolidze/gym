import java.util.*;

public class E14_BitonicSearch {
	public static void main(String[] args) {
		int[] xs = {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14};
		System.out.println(Arrays.asList(
			bitonicSearch(xs, 15) == 0,
			bitonicSearch(xs, 0) == -1,
			bitonicSearch(xs, 25) == 4,
			bitonicSearch(xs, 10) == 10
		));
	}

	public static int bitonicSearch(int[] xs, int elem) {
		int inflectionPoint = inflectionPoint(xs);

		if (inflectionPoint == -1) {
			return binarySearch(xs, elem, 0, xs.length - 1);
		}

		int firstHalf = binarySearch(xs, elem, 0, inflectionPoint );

		if (firstHalf != -1) {
			return firstHalf;
		}

		return binarySearch(xs, elem, inflectionPoint + 1, xs.length - 1);
	}


	public static int inflectionPoint(int[] xs) {
		if (xs.length < 3) {
			return -1;
		}

		for (int i = 1; i < xs.length - 2; i++) {
			if (xs[i - 1] < xs[i] && xs[i] > xs[i + 1]) {
				return i;
			}
		}

		return -1;
	}

	public static int binarySearch(int[] xs, int elem, int lo, int hi) {
		while (lo <= hi) {
			int mid = (lo + hi) / 2;
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

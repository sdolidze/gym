import java.util.*;

public class E01_SelectionSort {
	public static void main(String[] args) {
		int[] xs = {1, 2, 3, 3, 2, 1, 10};
		selectionSort(xs);
		System.out.println(Arrays.toString(xs));
		System.out.println(isSorted(xs));
	}

	public static void selectionSort(int[] xs) {
		for (int i = 0; i < xs.length; i++) {
			int minIndex = i;
			for (int j = i + 1; j < xs.length; j++) {
				if (xs[j] < xs[minIndex]) {
					minIndex = j;
				}
			}
			swap(xs, i, minIndex);
		}
	}

	public static boolean isSorted(int[] xs) {
		for (int i = 1; i < xs.length; i++) {
			if (xs[i - 1] > xs[i]) {
				return false;
			}
		}
		return true;
	}

	public static void swap(int[] xs, int i, int j) {
		int temp = xs[i];
		xs[i] = xs[j];
		xs[j] = temp;
	}
}

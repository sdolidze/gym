import java.util.*;

public class E02_InsertionSort {
	public static void main(String[] args) {
		int[] xs = {-10, 1, 2, 3, 5, 5, -2, 1, 10};
		insertionSort(xs);
		System.out.println(Arrays.toString(xs));
		System.out.println(E01_SelectionSort.isSorted(xs));
	}

	public static void insertionSort(int[] xs) {
		for (int i = 1; i < xs.length; i++) {
			int j = i;
			while (j - 1 >= 0 && xs[j] < xs[j-1]) {
				E01_SelectionSort.swap(xs, j - 1, j);
				j--;
			}
		}
	}
}

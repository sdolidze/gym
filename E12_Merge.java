import java.util.*;

public class E12_Merge {
	public static void main(String[] args) {
		int[] xs = {1, 2, 5, -1, -1, -1, -1};
		int[] ys = {0, 2, 4, 6};
		int[] zs = {0, 1, 2, 2, 4, 5, 6};
		merge(xs, 3, ys);
		System.out.println(Arrays.toString(xs));
		System.out.println(Arrays.equals(xs, zs));
	}

	public static void merge(int[] xs, int used, int[] ys) {
		assert xs.length == used + ys.length;
		int i = used - 1;
		int j = ys.length - 1;

		for (int k = xs.length - 1; k >= 0; k--) {
			if (j < 0 || (i >= 0 && xs[i] > ys[j])) {
				xs[k] = xs[i];
				i--; 
			} else {
				xs[k] = ys[j];
				j--;
			}
		}
	}
}

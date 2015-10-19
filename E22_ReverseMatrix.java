import java.util.*;

public class E22_ReverseMatrix {
	public static void main(String[] args) {
		int[][] matrix = {
			{1, 2, 3},
			{4, 5, 6},
			{7, 8, 9}
		};

		int[][] vertical = {
			{3, 2, 1},
			{6, 5, 4},
			{9, 8, 7}
};

int[][] horizontal = {
	{7, 8, 9},
	{4, 5, 6},
	{1, 2, 3}
};

reverseVertically(matrix);

System.out.println(Arrays.deepEquals(matrix, vertical));
	
reverseVertically(matrix);
reverseHorizontally(matrix);
System.out.println(Arrays.deepEquals(matrix, horizontal));
}
	
	
	public static void reverseVertically(int[][] matrix) {
		for (int[] row: matrix) {
			reverse(row);
}
}

public static void reverseHorizontally(int[][] matrix) {
	reverse(matrix);
}

public static void reverse(int[] xs) {
	for (int i = 0; i < xs.length / 2; i++) {
		swap(xs, i, xs.length - 1 - i);
}
}

public static void swap(int[] xs, int i, int j) {
	int temp = xs[i];
	xs[i] = xs[j];
	xs[j] = temp;
}

public static<T> void reverse(T[] xs) {
	for (int i = 0; i < xs.length / 2; i++) {
		swap(xs, i, xs.length - 1 - i);
}
}

public static<T> void swap(T[] xs, int i, int j) {
	T temp = xs[i];
	xs[i] = xs[j];
	xs[j] = temp;
}
}

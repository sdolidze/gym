import java.util.*;

public class E21_RotateMatrix {
	public static void main(String[] args) {
		int[][] matrix = {
			{1, 2, 3},
			{4, 5, 6},
			{7, 8, 9}
		};

		rotate270(matrix);

		for (int[] xs: matrix) {
			System.out.println(Arrays.toString(xs));
		}
	}

	public static void rotate90(int[][] matrix) {
		for (int layer = 0; layer < matrix.length / 2; layer++) {
			int first = layer;
			int last = matrix.length - 1 - layer;
			for (int offset = 0; offset < last - first; offset++) {
				// top    = (first       ,  first+offset)
				// right  = (first+offset,  last        )
				// bottom = (last        ,  last-offset )
				// left   = (last-offset ,  first       )
		
				// save top
				int top = matrix[first][first+offset];

				// top = right
				matrix[first][first+offset] = matrix[first+offset][last];

				// right = botton
			 	matrix[first+offset][last] = matrix[last][last-offset];

				// bottom  = left
			 	matrix[last][last-offset] = matrix[last-offset][first];

				// left = top
				matrix[last-offset][first] = top;
			}
		}
	}

	public static void rotate270(int[][] matrix) {
		for (int layer = 0; layer < matrix.length / 2; layer++) {
			int first = layer;
			int last = matrix.length - 1 - layer;
			for (int offset = 0; offset < last - first; offset++) {
				// top    = (first       ,  first+offset)
				// right  = (first+offset,  last        )
				// bottom = (last        ,  last-offset )
				// left   = (last-offset ,  first       )
		
				// save top
				int top = matrix[first][first+offset];
				
				// top = left
				matrix[first][first+offset] = matrix[last-offset][first];

				// left = bottom
				matrix[last-offset][first] = matrix[last][last-offset];

				// bottom = right
				matrix[last][last-offset] = matrix[first + offset][last];

				// right = top
				matrix[first+offset][last] = top;
			}
		}
	}
}

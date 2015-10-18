import java.util.*;

public class E16_CountSteps {
	public static void main(String[] args) {
		System.out.println(Arrays.asList(
			countSteps(1) == 1,
			countSteps(2) == 2,
			countSteps(3) == 4
		));
	}

	private static Map<Integer, Integer> memo = new HashMap<>();

	public static int countSteps(int n) {
		if (!memo.containsKey(n)) {
			if (n < 0) {
				return 0;
			} else if (n == 0) {
				return 1;
			} else {
				memo.put(n, countSteps(n - 3) + countSteps(n - 2) + countSteps(n - 1));
			}
		}

		return memo.get(n); 
	} 
}

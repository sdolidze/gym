import java.util.*;

public class E10_MinStack<T extends Comparable<T>> {
	public static void main(String[] args) {
		E10_MinStack<Integer> stack = new E10_MinStack<>();

		stack.push(2);
		stack.push(10);
		stack.push(3);
		stack.push(1);

		System.out.println(Arrays.asList(
			stack.min() == 1,
			stack.pop() == 1,
			stack.min() == 2,
			stack.pop() == 3,
			stack.min() == 2,
			stack.pop() == 10,
			stack.min() == 2,
			stack.pop() == 2
		));
	}

	private static class List<T> {
		private T elem;
		private List<T> next;

		public List(T elem, List<T> next) {
			this.elem = elem;
			this.next = next;
		}
	}

	private List<T> elems;
	private List<T> mins;

	public void push(T elem) {
		T newMin = mins == null ? elem : min(mins.elem, elem);
		elems = new List<>(elem, elems);
		mins = new List<>(newMin, mins);
	}

	private T min(T one, T two) {
		return two.compareTo(one) < 0 ? two : one;
	}

	public T pop() {
		T elem = elems.elem;
		elems = elems.next;
		mins = mins.next;
		return elem;
	}

	public T min() {
		return mins.elem;
	}
}

import java.util.*;

public class E11_BankersQueue<T> {
	public static void main(String[] args) {
		E11_BankersQueue<Integer> queue = new E11_BankersQueue<>();

		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);

		System.out.println(queue.dequeue() == 1);

		queue.enqueue(4);
		queue.enqueue(5);

		System.out.println(Arrays.asList(
			queue.dequeue() == 2,
			queue.dequeue() == 3,
			queue.dequeue() == 4,
			queue.dequeue() == 5
		));
	}

	private Stack<T> front = new Stack<>();
	private Stack<T> back = new Stack<>();

	public void enqueue(T elem) {
		front.push(elem);
	}

	public T dequeue() {
		if (back.isEmpty()) {
			if (front.isEmpty()) {
				throw new RuntimeException("empty queue");
			}

			while (!front.isEmpty()) {
				back.push(front.pop());
			}
		}

		return back.pop();
	}
}

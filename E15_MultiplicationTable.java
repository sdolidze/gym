public class E15_MultiplicationTable {
	public static void main(String[] args) {
		System.out.println(multiplicationTable());
	}

	public static String multiplicationTable() {
		int size = 12;
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= size; i++) {
			for (int j = 1; j <= size; j++) {
				sb.append(String.format("%3d", i * j));
				if (j != size) {
					sb.append(' ');
				}
			}
			if (i != size) {
				sb.append('\n');
			}
		}
		return sb.toString();
	}
}

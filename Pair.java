public class Pair<Left, Right> {
	private final Left left;
	private final Right right;

	private Pair(Left left, Right right) {
		this.left = left;
		this.right = right;
	}
	
	public static<Left, Right> Pair<Left, Right> of(Left left, Right right) {
		return new Pair<Left, Right>(left, right);
	}

	public Left left() {
		return left;
	}

	public Right right() {
		return right;
	}

	@Override
	public String toString() {
		return "(" + left  + "," + right + ")";
	}

	@Override
	public boolean equals(Object that) {
		return toString().equals(that.toString());
	}

	@Override
	public int hashCode() {
		return toString().hashCode();
	}
}
import java.util.*;

public class E17_RobotMovement {
	public static void main(String[] args) {
		System.out.println(Arrays.asList(
			robotMovement(2, 2) == 6,
			robotMovement(3, 3) == 20
		));
	}

	public static int robotMovement(int x, int y) {
		if (x < 0 || y < 0) {
			return 0;
		} else if (x == 0 && y == 0) {
			return 1;
		} else {
			return robotMovement(x - 1, y) + robotMovement(x, y - 1);
		}
	}
}

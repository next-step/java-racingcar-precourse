package racingcar;

public class RacingRule {
	public static final int MIN_MOVE_VALUE = 4;

	public static boolean isMovable(int random) {
		return random >= MIN_MOVE_VALUE;
	}
}

package racingcar;

public class RacingRule {

	public static final int MIN_NAME_LENGTH = 1;
	public static final int MAX_NAME_LENGTH = 5;
	public static final int MIN_MOVE_VALUE = 4;

	public static boolean isInvalidCarName(String carName) {
		return carName.length() < MIN_NAME_LENGTH || carName.length() > MAX_NAME_LENGTH;
	}

	public static boolean isMovable(int random) {
		return random >= MIN_MOVE_VALUE;
	}
}

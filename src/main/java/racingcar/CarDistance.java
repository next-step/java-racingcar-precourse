package racingcar;

public class CarDistance {
	private static final int MOVE_CRITERIA = 4;
	private static final int MINIMUM_MOVE_CONDITION = 0;
	private static final int MAXIMUM_MOVE_CONDITION = 9;

	private int distance;

	public CarDistance() {
		distance = 0;
	}

	public int move(int condition) {
		validateCarForwardConditionIsBetween0to9(condition);
		if (MOVE_CRITERIA <= condition) {
			distance++;
		}

		return distance;
	}

	private void validateCarForwardConditionIsBetween0to9(int condition) {
		if (condition < MINIMUM_MOVE_CONDITION || MAXIMUM_MOVE_CONDITION < condition) {
			throw new IllegalArgumentException("전진하는 조건은 0에서 9 사이의 값이어야 합니다.");
		}
	}

	public int getDistance() {
		return distance;
	}
}

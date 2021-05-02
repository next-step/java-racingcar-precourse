package racingcar;

public class CarDistance {
	private int distance;

	public CarDistance() {
		distance = 0;
	}

	public int getDistance() {
		return distance;
	}

	public void move(int condition){
		validationCarForwardConditionIsBetween0to9(condition);
		if (4 <= condition) {
			distance++;
		}
	}

	private void validationCarForwardConditionIsBetween0to9(int condition) {
		if (condition < 0 || 9 < condition) {
			throw new IllegalArgumentException("전진하는 조건은 0에서 9 사이의 값이어야 합니다.");
		}
	}
}

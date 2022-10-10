package racingcar.code;

public enum CarValueRange {
	MIN_NAME_LENGTH(1),
	MAX_NAME_LENGTH(5),
	MIN_NUMBER_RANGE(0),
	MAX_NUMBER_RANGE(9);

	private int carValueRange;

	CarValueRange(int carValueRange) {
		this.carValueRange = carValueRange;
	}

	public int getCarValueRange() {
		return carValueRange;
	}
}

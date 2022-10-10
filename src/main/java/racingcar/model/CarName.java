package racingcar.model;

public class CarName {
	private static final int CAR_NAME_MAX_LENGTH = 5;
	private final String value;

	private CarName(String value) {
		String trimmed = value.trim();
		validate(trimmed);
		this.value = trimmed;
	}

	public static CarName from(String carName) {
		return new CarName(carName);
	}

	private void validate(String carName) {
		if (carName.length() > CAR_NAME_MAX_LENGTH) {
			throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
		}

		if (carName.isEmpty()) {
			throw new IllegalArgumentException("자동차 이름이 공백일 수는 없습니다.");
		}
	}

	public String getValue() {
		return value;
	}
}

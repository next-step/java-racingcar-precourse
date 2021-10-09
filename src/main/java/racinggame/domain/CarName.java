package racinggame.domain;

public class CarName {
	public static final String ERROR_MESSAGE = "[ERROR] 자동차 이름은 5글자 이하로 입력해주세요.";
	public static final int MAX_LENGTH_NAME = 5;

	private String carName;

	public CarName(String carName) {
		validateCarName(carName);
		this.carName = carName;
	}

	private void validateCarName(String carName) {
		if (!validateCarNameLength(carName)) {
			throw new IllegalArgumentException(ERROR_MESSAGE);
		}
	}

	private boolean validateCarNameLength(String carName) {
		return carName.length() <= MAX_LENGTH_NAME;
	}

	public String getCarName() {
		return carName;
	}
}

package racinggame.domain;

public class CarName {
	static final String ERROR_MESSAGE = "[ERROR] 자동차의 이름은 5자 이하입니다. 다시 입력해주세요.";
	private static final int INPUT_LIMIT = 5;

	private String carName;

	CarName(String carName) {
		this.carName = carName;
	}

	public String value() {
		return carName;
	}

	public static boolean isOverThanFiveLetters(String input) {
		if (input.length() > INPUT_LIMIT) {
			System.out.println(ERROR_MESSAGE);
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return carName;
	}
}

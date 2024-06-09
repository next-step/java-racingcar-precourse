package raceCar;

public class GameValidator {
	public static String validateUserCarInput(String carNames) {
		for(String carName : carNames.split(",")) {
			validateCarName(carName);
		}
		return carNames;
	}

	public static String validateNumber(String input) {
		try {
			Integer.parseInt(input);
			return input;
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("숫자 형식이 아님");
		}
	}

	private static void validateCarName(String carName) {
		if (Constant.MIN_CAR_LENGTH.value < carName.length() && carName.length() <= Constant.MAX_CAR_LENGTH.value) {
			return;
		}
		throw new IllegalArgumentException("자동차 이름 길이가 잘못되었습니다.");
	}

	enum Constant {
		MAX_CAR_LENGTH(5),
		MIN_CAR_LENGTH(1);
		private final int value;

		Constant(int value) {
			this.value = value;
		}
	}
}

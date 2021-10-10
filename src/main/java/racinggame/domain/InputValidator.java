package racinggame.domain;

public class InputValidator {

	public void validCarName(String input) {
		checkEmptyInput(input);
		checkNumberOfCarNames(input);
		checkCarNameLength(input);
	}

	public void validTryNumber(String input) {
		checkEmptyInput(input);
		checkDigitOnly(input);
		checkGreaterThenOne(input);
	}

	private void checkEmptyInput(String input) {
		if (input.isEmpty()) {
			throw new IllegalArgumentException("[ERROR] 빈 문자열 입력");
		}
	}

	private void checkNumberOfCarNames(String input) {
		String replaced = input.replaceAll(",", "");
		int numOfCarNames = input.length() - replaced.length() + 1;

		String[] carNames = input.split(",");
		if (carNames.length < numOfCarNames) {
			throw new IllegalArgumentException("[ERROR] 자동자 이름 개수 부족");
		}
	}

	private void checkCarNameLength(String input) {
		String[] carNames = input.split(",");
		for (String carName : carNames) {
			lengthShouldLessThen(carName);
		}
	}

	private void lengthShouldLessThen(String input) {
		if (input.length() > 5 || input.length() < 1) {
			throw new IllegalArgumentException("[ERROR] 자동차 이름은 5이하만 가능");
		}
	}

	private void checkDigitOnly(String input) {
		try {
			Integer.parseInt(input);
		} catch (NumberFormatException exception) {
			throw new IllegalArgumentException("[ERROR] 문자 입력");
		}
	}

	private void checkGreaterThenOne(String input) {
		int number = Integer.parseInt(input);
		if (number < 1) {
			throw new IllegalArgumentException("[ERROR] 1보다 작은 수 입력");
		}
	}
}

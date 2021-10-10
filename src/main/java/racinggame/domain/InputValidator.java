package racinggame.domain;

public class InputValidator {

	public boolean validCarName(String input) {
		checkEmptyInput(input, "[ERROR] 빈 문자열 입력");
		checkNumberOfCarNames(input);
		checkEmptyCarName(input);

		return true;
	}

	public boolean validTryNumber(String input) {
		checkEmptyInput(input, "[ERROR] 빈 문자열 입력");
		checkDigitOnly(input);
		checkGreaterThenOne(input);

		return true;
	}

	private void checkEmptyInput(String input, String errorMessage) {
		if (input.isEmpty()) {
			throw new IllegalArgumentException(errorMessage);
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

	private void checkEmptyCarName(String input) {
		String[] carNames = input.split(",");
		for (String carName : carNames) {
			checkEmptyInput(carName, "[ERROR] 빈 자동자 이름 입력");
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

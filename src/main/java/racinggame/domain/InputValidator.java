package racinggame.domain;

public class InputValidator {

	public void validCarName(String input) {
		checkEmptyInput(input, "[ERROR] 빈 문자열 입력, 다시 입력해주세요: ");
		checkNumberOfCarNames(input);
		checkEmptyCarName(input);
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
			throw new IllegalArgumentException("[ERROR] 자동자 이름 개수 부족, 다시 입력해주세요: ");
		}
	}

	private void checkEmptyCarName(String input) {
		String[] carNames = input.split(",");
		for (String carName : carNames) {
			checkEmptyInput(carName, "[ERROR] 빈 자동자 이름 입력, 다시 입력해주세요: ");
		}
	}

}

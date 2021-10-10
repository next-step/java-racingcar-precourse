package racinggame.domain;

import nextstep.utils.Console;

public class RaceFactory {

	private final InputValidator validator = new InputValidator();

	public Race buildRace() {
		LineUp lineUp = buildLineUp();
		Integer tryNumber = receiveTryNumber();

		return new Race(lineUp, tryNumber);
	}

	private LineUp buildLineUp() {
		String carNames = receiveCarNames();
		return new LineUp(carNames);
	}

	private String receiveCarNames() {
		String input;
		do {
			System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
			input = Console.readLine();
		} while (isInValidCarNameInput(input));

		return input;
	}

	private boolean isInValidCarNameInput(String input) {
		try {
			validator.validCarName(input);
			return false;
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
			return true;
		}
	}

	private Integer receiveTryNumber() {
		String input;
		do {
			System.out.println("시도할 회수는 몇회인가요?");
			input = Console.readLine();
		} while (isInValidTryNumberInput(input));

		return Integer.parseInt(input);
	}

	private boolean isInValidTryNumberInput(String input) {
		try {
			validator.validTryNumber(input);
			return false;
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
			return true;
		}
	}
}

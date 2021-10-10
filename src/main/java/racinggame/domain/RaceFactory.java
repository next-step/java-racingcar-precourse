package racinggame.domain;

import java.util.ArrayList;
import java.util.List;

import nextstep.utils.Console;

public class RaceFactory {

	private final InputValidator validator = new InputValidator();
	private final Message message = new Message();

	public Race buildRace() {
		LineUp lineUp = buildLineUp();
		Integer tryNumber = receiveTryNumber();

		return new Race(lineUp, tryNumber);
	}

	private LineUp buildLineUp() {
		String carNames = receiveCarNames();
		List<Car> cars = buildCarList(carNames);
		return new LineUp(cars);
	}

	private List<Car> buildCarList(String input) {
		List<Car> cars = new ArrayList<>();
		String[] carNames = input.split(",");

		for (String carName : carNames) {
			cars.add(new Car(carName));
		}

		return cars;
	}

	private String receiveCarNames() {
		String input;
		do {
			message.enterCarNam();
			input = Console.readLine();
		} while (isInValidCarNameInput(input));

		return input;
	}

	private boolean isInValidCarNameInput(String input) {
		try {
			validator.validCarName(input);
			return false;
		} catch (IllegalArgumentException exception) {
			message.printErrorCause(exception);
			return true;
		}
	}

	private Integer receiveTryNumber() {
		String input;
		do {
			message.enterEnterTryNumber();
			input = Console.readLine();
		} while (isInValidTryNumberInput(input));

		return Integer.parseInt(input);
	}

	private boolean isInValidTryNumberInput(String input) {
		try {
			validator.validTryNumber(input);
			return false;
		} catch (IllegalArgumentException exception) {
			message.printErrorCause(exception);
			return true;
		}
	}
}

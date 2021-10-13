package racinggame.controller;

import java.util.Arrays;
import java.util.regex.Pattern;

import racinggame.model.Car;
import racinggame.model.Cars;
import racinggame.view.InputVIew;
import racinggame.view.OutputVIew;

public class RacingCarGame {

	private static final String CAR_NAME_DELIMITER = ",";
	private static final String CHECK_NUMBER = "(^[0-9]*$)";

	private final InputVIew inputVIew = new InputVIew();
	private final OutputVIew outputVIew = new OutputVIew();

	public void gameStart() {
		Cars cars = getCars();
		int raceCount = getRaceCount();
		while (raceCount-- > 0) {
			cars.race();
			outputInGame(cars);
		}
		outputVIew.outputWinners(cars);
	}

	private int getRaceCount() {
		int raceCount = -1;
		while (raceCount < 0) {
			raceCount = getRaceNumber(inputVIew.inputRaceNumber());
		}
		return raceCount;
	}

	private Cars getCars() {
		Cars cars = null;
		while (cars == null) {
			cars = makeCars(inputVIew.inputCarName());
		}
		return cars;
	}

	private Cars makeCars(String names) {
		Cars cars = null;
		try {
			cars = new Cars(Arrays.asList(names.split(CAR_NAME_DELIMITER)));
		} catch (Exception e) {
			outputVIew.outputErrorMessage(e.getMessage());
		}
		return cars;
	}

	private int getRaceNumber(String raceNumber) {
		int returnNumber;
		try {
			returnNumber = stringToInt(raceNumber);
		} catch (Exception e) {
			outputVIew.outputErrorMessage(e.getMessage());
			return -1;
		}
		return returnNumber;
	}

	private int stringToInt(String number) {
		if (isNotNumber(number)) {
			throw new NumberFormatException("0 이상의 숫자만 입력해주시기 바랍니다.");
		}
		return Integer.parseInt(number);
	}

	private boolean isNotNumber(String number) {
		return !Pattern.matches(CHECK_NUMBER, number);
	}

	private void outputInGame(Cars cars) {
		for (Car car : cars.getCars()) {
			outputVIew.outputInGame(car);
		}
		outputVIew.outputNewLine();
	}

}

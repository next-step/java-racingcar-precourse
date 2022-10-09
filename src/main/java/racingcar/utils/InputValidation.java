package racingcar.utils;

import java.util.Arrays;

public class InputValidation {

	private static final int MIN_NAME_LENGTH = 1;
	private static final int MAX_NAME_LENGTH = 5;

	public static boolean parseInputValueCar(String inputValue) {
		Arrays.stream(inputValue.split(","))
				.allMatch(InputValidation::validLength);
		return true;
	}

	public static boolean validLength(Object inputValue) {
		if(!(inputValue instanceof String))
			throw new IllegalArgumentException();
		String car = (String) inputValue;
		if(car.length() < MIN_NAME_LENGTH || car.length() > MAX_NAME_LENGTH) {
			throw new IllegalArgumentException();
		}
		return true;
	}

	public static int intValueChecking(String inputNumber) {
		try {
			return Integer.parseInt(inputNumber);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException();
		}
	}
}

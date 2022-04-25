package racingcar.domain;

import racingcar.utils.Error;

public class Validator {
	private static final String NUMBER_REG_EX = "^[0-9]*$";

	public static void validNumber(String input) {
		if(!input.matches(NUMBER_REG_EX)) {
			throw new IllegalArgumentException(Error.INVALID_NUMBER.getMessage());
		}
	}
}

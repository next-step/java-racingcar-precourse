package racingcar.util;

import racingcar.constants.RacingCarMessage;
import racingcar.constants.RacingCarNum;
import racingcar.view.RacingCarError;

public class RacingCarValidation {

	public static boolean validateCarName(String carNames) {
		String[] carNameList = carNames.split(RacingCarMessage.CAR_NAME_COMMA);
		try {
			validationCarList(carNameList);
		} catch (IllegalArgumentException e) {
			RacingCarError.printCarName(RacingCarMessage.ERROR_PREFIX + e.getMessage());
			return false;
		}
		return true;
	}

	private static boolean validationCarList(String[] carNameList) {
		for (String carName : carNameList) {
			validateCarNameLength(carName);
		}
		return true;
	}

	private static boolean validateCarNameLength(String carName) {
		if (carName.length() <= RacingCarNum.CAR_NAME_MAX && carName.length() >= RacingCarNum.CAR_NAME_MIN) {
			return true;
		}
		throw new IllegalArgumentException(RacingCarMessage.MESSAGE_VALIDATION_INPUT_LENGTH);
	}

	public static boolean validateAttemptNum(String attemptNum) {
		try {
			Integer.parseInt(attemptNum);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(RacingCarMessage.ERROR_PREFIX + RacingCarMessage.MESSAGE_VALIDATION_INPUT_NUM);
		}
		return validateAttemptNumPlus(attemptNum);
	}

	private static boolean validateAttemptNumPlus(String attemptNumber) {
		if (Integer.parseInt(attemptNumber) >= RacingCarNum.ATTEMPT_NUM_MIN) {
			return true;
		}
		throw new IllegalArgumentException(RacingCarMessage.ERROR_PREFIX + RacingCarMessage.MESSAGE_VALIDATION_INPUT_NUM);
	}

}

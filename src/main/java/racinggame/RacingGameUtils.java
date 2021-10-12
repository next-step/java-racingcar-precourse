package racinggame;

import nextstep.utils.Randoms;

public class RacingGameUtils {
	private static final int MIN_NUMBER = 0;
	private static final int MAX_NUMBER = 9;
	private static final int MIN_NAME_LENGTH = 0;
	private static final int MAX_NAME_LENGTH = 5;

	public static Boolean validationRandomNumber(int randomNumber) {
		return randomNumber >= MIN_NUMBER && randomNumber <= MAX_NUMBER;
	}

	public static int getRandomNumber() throws Exception {
		int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);

		if(!validationRandomNumber(randomNumber)) {
			throw new Exception();
		}

		return randomNumber;
	}

	public static Boolean validationCarName(String carNames) {
		int nameLength = carNames.length();
		return nameLength > MIN_NAME_LENGTH && nameLength <= MAX_NAME_LENGTH;
	}
}

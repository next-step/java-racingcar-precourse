package racingcar;

import java.util.Random;

public class Generator {
	private static int MAX_RANDOM_NUMVER = 9;

	public static int randomNumber() {
		Random random = new Random();
		return random.nextInt(MAX_RANDOM_NUMVER);
	}
}

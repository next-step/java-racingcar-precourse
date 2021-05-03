package utils;

import java.util.Random;

public class RandomUtils {

	public static int getOneDigitRandomNumber() {
		Random random = new Random();
		return random.nextInt(10);
	}

}

package utils;

import java.util.Random;

public class RandomNumberGenerator {
	public static final int MAX_NUMBER = 10;

	public static int getRandomNumber() {
		return new Random().nextInt(MAX_NUMBER);
	}
}

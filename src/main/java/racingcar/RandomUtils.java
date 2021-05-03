package racingcar;

import java.util.Random;

public class RandomUtils {
	private static Random random = new Random();

	public static int make() {
		return random.nextInt(10);
	}
}

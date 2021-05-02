package home.work.racing;

import java.security.SecureRandom;

import home.work.racing.wrap.RandomResult;

public class RandomUtils {
	
	private static final int MAX_RAND_VAL = 9;
	private static SecureRandom random = new SecureRandom();
	
	public static RandomResult random() {
		return new RandomResult(random.nextInt(MAX_RAND_VAL) + 1);
	}

}
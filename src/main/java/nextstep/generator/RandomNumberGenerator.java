package nextstep.generator;

import nextstep.utils.Randoms;

public class RandomNumberGenerator {

	private static final int MIN_RANDOM_NUMBER = 0;
	private static final int MAX_RANDOM_NUMBER = 9;

	private static RandomNumberGenerator INSTANCE = new RandomNumberGenerator();

	private RandomNumberGenerator() {
	}

	public int generate() {
		return Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
	}

	public static RandomNumberGenerator getInstance() {
		return INSTANCE;
	}
}

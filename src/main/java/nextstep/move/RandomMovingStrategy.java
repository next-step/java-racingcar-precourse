package nextstep.move;

import nextstep.generator.RandomNumberGenerator;

public class RandomMovingStrategy extends MovingStrategy {

	private static final RandomMovingStrategy INSTANCE = new RandomMovingStrategy();

	private RandomMovingStrategy() {
		super(RandomNumberGenerator.getInstance());
	}

	public static RandomMovingStrategy getInstance() {
		return INSTANCE;
	}

}

package racingcar.strategy;

import racingcar.domain.NumberGenerator;
import racingcar.domain.RandomNumberGenerator;

public class RandomStrategy implements MovingStrategy {

	private static final int MOVING_CONDITION = 4;
	private final NumberGenerator numberGenerator;

	public RandomStrategy() {
		this.numberGenerator = new RandomNumberGenerator();
	}

	@Override
	public boolean isMovable() {
		return isMovable(numberGenerator.generateNumber());
	}

	protected boolean isMovable(int number) {
		return number >= MOVING_CONDITION;
	}

}

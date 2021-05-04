package domain.car.strategy;

import java.util.Random;

public class RandomMovableStrategy implements MovableStrategy {

	public static final int BOUND = 10;

	public static final int MIN_RANGE = 4;

	public static final int MAX_RANGE = 9;

	private final Random random = new Random();

	@Override
	public boolean movable() {
		return isMovable();
	}

	private boolean isMovable() {
		int randomValue = generateRandomValue();
		return randomValue >= MIN_RANGE && randomValue <= MAX_RANGE;
	}

	private int generateRandomValue(){
		return random.nextInt(BOUND);
	}
}

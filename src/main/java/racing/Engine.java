package racing;

import java.util.Random;

public class Engine {
	private static final int POWER_LIMIT = 10;
	private static final int FORWARD_THRESHOLD = 4;

	private Random random;

	public Engine() {
		this.random = new Random();
	}

	public int getPower() {
		return this.random.nextInt(POWER_LIMIT);
	}

	public CarStatus run(int power) {
		return power >= FORWARD_THRESHOLD ? CarStatus.FORWARD : CarStatus.STOP;
	}
}

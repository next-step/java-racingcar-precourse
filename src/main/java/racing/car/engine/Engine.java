package racing.car.engine;

import java.util.Random;

import racing.car.CarStatus;

public class Engine {
	private static final int POWER_LIMIT = 10;
	private static final int FORWARD_THRESHOLD = 4;

	private Random random;

	public Engine() {
		this.random = new Random();
	}

	public Power getPower() {
		int val = this.random.nextInt(POWER_LIMIT);
		return new Power(val);
	}

	public CarStatus run(Power power) {
		return power.getVal() >= FORWARD_THRESHOLD ? CarStatus.FORWARD : CarStatus.STOP;
	}
}

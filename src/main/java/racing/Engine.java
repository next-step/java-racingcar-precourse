package racing;

import java.util.Random;

public class Engine {
	private Random random;

	public Engine() {
		this.random = new Random();
	}

	public int getPower() {
		return this.random.nextInt(10);
	}
}

package racingcar;

import java.util.Random;

public class Generator {
	public int randomNumber() {
		Random random = new Random();
		return random.nextInt(9);
	}
}

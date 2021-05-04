package racing.game.domain.car;

import java.util.Random;

import racing.game.properties.RacingSystemProperties;

public class Accelerator {
	public static boolean isMove() {
		return generateRandomNum() >= RacingSystemProperties.ACCEL_MIN_NO;
	}

	public static int generateRandomNum() {
		return new Random().nextInt(9);
	}
}

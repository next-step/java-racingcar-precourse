package precourse.utility;

import java.util.Random;

public class MovementNumberGenerator {

	public static final int BOUND_NUMBER = 10;

	public static MovementNumber createMovementNumber() {
		int number = new Random().nextInt(BOUND_NUMBER);
		return new MovementNumber(number);
	}

}

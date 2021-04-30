package racing.game.domain;

import java.util.Random;

public class Accelerator {

	public static final int ACCEL_MIN_NO = 4;

	// public static boolean validNo(int inputNo) {
	// 	return inputNo >= ACCEL_MIN_NO; //Ctrl + Alt + C 상수 생성
	// }

	public static boolean isMove() {
		return generateRandomNum() >= ACCEL_MIN_NO;
	}

	public static int generateRandomNum() {
		return new Random().nextInt(9);
	}
}

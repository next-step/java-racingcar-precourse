package view;

import java.util.Scanner;

import model.Mileage;
import model.RacingCar;
import model.RacingCars;

public interface RacingGameView {

	default String[] getRacingCarNames() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		return new Scanner(System.in).nextLine().split(",");
	}

	public static int getRoundNum() {
		System.out.println("시도할 회수는 몇회인가요?");
		int roundNum;
		try {
			roundNum = new Scanner(System.in).nextInt();
		} catch (InputMismatchException ignored) {
			roundNum = -1;
		}
		if (roundNum < 0)
			throw new RacingGameException("유효하지 않은 수가 입력되었습니다.");
		return roundNum;
	}

	public static void printRoundResult(final RacingCars racingCars) {
		for (RacingCar racingCar : racingCars.getValue()) {
			System.out.println(
				racingCar.getName().getValue() + " : " + makeProgressBar(racingCar.getMileage())
			);
		}
		System.out.println();
	}

	default String makeProgressBar(final Mileage mileage) {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < mileage.getValue(); i++) {
			stringBuilder.append("-");
		}
		return stringBuilder.toString();
	}

	private static String makeProgressBar(final Mileage mileage) {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < mileage.getValue(); i++) {
			stringBuilder.append("-");
		}
		return stringBuilder.toString();
	}
}

package view;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import exception.RacingGameException;
import model.CarName;
import model.Mileage;
import model.RacingCar;
import model.RacingCars;

public class RacingGameView {

	public static String[] getRacingCarNames() {
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

	public static void printWinners(final List<CarName> maxMileageCarNames) {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < maxMileageCarNames.size(); i++) {
			stringBuilder.append(
				maxMileageCarNames.get(i).getValue()
			);
			stringBuilder.append(i < maxMileageCarNames.size() - 1 ? ", " : "");
		}
		System.out.println(stringBuilder + "가 최종 우승했습니다.\n");
	}

	private static String makeProgressBar(final Mileage mileage) {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < mileage.getValue(); i++) {
			stringBuilder.append("-");
		}
		return stringBuilder.toString();
	}
}

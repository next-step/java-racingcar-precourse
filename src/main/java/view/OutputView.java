package view;

import java.util.List;

import domain.RacingCar;
import domain.RacingCars;

public class OutputView {
	private static final String POSITION_LENGH_STRING = "-";

	public static void currentCarsView(int count, RacingCars racingCars) {
		if (count == 0) {
			System.out.println("실행 결과");
		}
		for (RacingCar racingCar : racingCars.get()) {
			System.out.printf("%s: %s%n", racingCar.getRacingCarName().get(),
				mapPosition(racingCar.getPosition().get()));
		}
		System.out.println();
	}

	public static String mapPosition(int position) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < position; i++) {
			builder.append(POSITION_LENGH_STRING);
		}
		return builder.toString();
	}

	public static void winnerView(List<String> racingCars) {
		System.out.printf("%s가 최종 우승했습니다.\n", String.join(",", racingCars));
	}
}

public class OutputView {
	public static void currentCarsView(int count, RacingCars racingCars) {
		if (count == 0) {
			System.out.println("실행 결과");
		}
		for (RacingCar racingCar : racingCars.get()) {
			System.out.printf("%s: %s%n", racingCar.getRacingCarName().get(), mapCount(racingCar.getMoveCount().get()));
		}
		System.out.println();
	}

	static String mapCount(int moveCount) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < moveCount; i++) {
			builder.append("-");
		}
		return builder.toString();
	}
}

package racinggame;

public class RacingGameView {

	public static final String MSG_GAME_RESULT = "실행 결과";
	public static final String FORMAT_CAR_IN_GAME_RESULT = "%s : %s";

	public void outputRacingResult(Cars cars) {
		System.out.println(MSG_GAME_RESULT);
		outputCarDistance(cars);
	}

	private void outputCarDistance(Cars cars) {
		for (Car car : cars.getCars()) {
			System.out.printf((FORMAT_CAR_IN_GAME_RESULT) + "%n", car.getName(), car.getDistance());
		}
		System.out.println("");
	}

	public void outputWinner(Cars cars) {
		System.out.printf("최종 우승자는 %s 입니다.", cars.getWinners());
	}
}

package racinggame;

public class RacingGameView {

	public static final String MSG_GAME_RESULT = "실행 결과";
	public static final String MSG_FORMAT_CAR_IN_GAME_RESULT = "%s : %s";
	public static final String MSG_FORMAT_WINNERS = "최종 우승자는 %s 입니다.";

	public void outputRacingResultTitle() {
		System.out.println(MSG_GAME_RESULT);
	}

	public void outputRacingResultBody(Cars cars) {
		for (Car car : cars.getCars()) {
			System.out.printf(MSG_FORMAT_CAR_IN_GAME_RESULT, car.getName(),
				getSymbolFromCarDistance(car.getDistance()));
			System.out.println("");
		}
		System.out.println("");
	}

	private String getSymbolFromCarDistance(int distance) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < distance; ++i) {
			sb.append("-");
		}
		return sb.toString();
	}

	public void outputWinner(Cars cars) {
		System.out.printf(MSG_FORMAT_WINNERS, cars.getWinners());
	}
}

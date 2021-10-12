package racinggame.domain;

import nextstep.utils.Randoms;

public class RacingGame {
	private final Cars cars;
	private final Cycle cycle;
	private final String executionResultMessage = "실행 결과";
	private final int randomMin = 0;
	private final int randomMax = 9;
	private final String winnersMessage = "최종 우승자는 %s 입니다.%n";

	public RacingGame(Cars cars, Cycle cycle) {
		this.cars = cars;
		this.cycle = cycle;
	}

	public void start() {
		System.out.println(executionResultMessage);

		for (int i = 0; i < cycle.value(); i++) {
			race();
		}

		printWinners(Winners.init(cars));
	}

	private void race() {
		for (Car car : cars.value()) {
			car.distance(Randoms.pickNumberInRange(randomMin, randomMax));
			System.out.println(car);
		}
		System.out.println();
	}

	private void printWinners(Winners winners) {
		StringBuilder winnersName = new StringBuilder();

		for (Car winner : winners.value()) {
			winnersName.append(winner.carName().value()).append(",");
		}

		System.out.printf(winnersMessage, winnersName.substring(0, winnersName.lastIndexOf(",")));
	}
}

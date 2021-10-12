package racinggame;

import nextstep.utils.Randoms;

public class RacingGame {
	private final Cars cars;
	private final Cycle cycle;
	private final String executionResultMessage = "실행 결과";
	private final int randomMin = 0;
	private final int randomMax = 9;

	public RacingGame(Cars cars, Cycle cycle) {
		this.cars = cars;
		this.cycle = cycle;
	}

	/**
	 * @author : yh22953905
	 * @Date : 2021/10/11 12:55 오전
	 * @Description : 게임 시작
	 *
	 **/
	void start() {
		System.out.println(executionResultMessage);

		for (int i = 0; i < cycle.value(); i++) {
			race();
		}

		printWinners(Winners.init(cars));
	}

	/**
	 * @author : yh22953905
	 * @Date : 2021/10/11 12:56 오전
	 * @Description : 경기 시작
	 *
	 **/
	private void race() {
		for (Car car : cars.value()) {
			car.distance(Randoms.pickNumberInRange(randomMin, randomMax));
			System.out.println(car);
		}
		System.out.println();
	}

	/**
	 * @author : yh22953905
	 * @Date : 2021/10/12 1:19 오전
	 * @Description : 최종 우승자들을 출력
	 *
	 **/
	private void printWinners(Winners winners) {
		String winnersName = "";

		for (Car winner : winners.value()) {
			winnersName += winner.carName().value() + ",";
		}

		System.out.println(String.format("최종 우승자는 %s 입니다.", winnersName.substring(0, winnersName.lastIndexOf(","))));
	}
}

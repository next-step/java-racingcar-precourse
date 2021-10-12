package racinggame;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import nextstep.utils.Randoms;

public class RacingGame {
	private final Cars cars;
	private final String executionResultMessage = "실행 결과";
	private final int randomMin = 0;
	private final int randomMax = 9;

	public RacingGame(Cars cars) {
		this.cars = cars;
	}

	/**
	 * @author : yh22953905
	 * @Date : 2021/10/11 12:55 오전
	 * @Description : 게임 시작
	 *
	 **/
	void start() {
		CycleInput.init();

		System.out.println(executionResultMessage);

		for (int i = 0; i < CycleInput.value().cycle(); i++) {
			race();
		}

		printWinners(getWinners());
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
	 * @Date : 2021/10/12 1:16 오전
	 * @Description : 최종 우승자를 가져옴
	 *
	 **/
	private List<Car> getWinners() {
		sortCarsByDistance();

		return pickWinners();
	}

	/**
	 * @author : yh22953905
	 * @Date : 2021/10/12 1:18 오전
	 * @Description : 자동차들을 distance 순으로 정렬
	 *
	 **/
	private void sortCarsByDistance() {
		cars.value().sort(Comparator.comparingInt((Car car) -> car.distance().value()).reversed());
	}

	/**
	 * @author : yh22953905
	 * @Date : 2021/10/12 1:18 오전
	 * @Description : 정렬된 자동차들을 토대로 최종 우승자들을 선별
	 *
	 **/
	private List<Car> pickWinners() {
		List<Car> winners = new ArrayList<>();
		int winnerDistance = 0;

		for (Car car : cars.value()) {
			if (winnerDistance > car.distance().value()) {
				return winners;
			}
			winnerDistance = car.distance().value();
			winners.add(car);
		}

		return winners;
	}

	/**
	 * @author : yh22953905
	 * @Date : 2021/10/12 1:19 오전
	 * @Description : 최종 우승자들을 출력
	 *
	 **/
	private void printWinners(List<Car> winners) {
		String winnersName = "";

		for (Car winner : winners) {
			winnersName += winner.carName().value() + ",";
		}

		System.out.println(String.format("최종 우승자는 %s 입니다.", winnersName.substring(0,winnersName.lastIndexOf(","))));
	}
}

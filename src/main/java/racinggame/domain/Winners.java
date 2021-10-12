package racinggame.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Winners {
	private static List<Car> winners = new ArrayList<>();

	private Winners(Cars cars) {
		sortCarsByDistance(cars);
		pickWinners(cars);
	}

	public static Winners init(Cars cars) {
		return new Winners(cars);
	}

	public List<Car> value() {
		return winners;
	}

	/**
	 * @author : yh22953905
	 * @Date : 2021/10/12 1:18 오전
	 * @Description : 자동차들을 distance 순으로 정렬
	 *
	 **/
	private void sortCarsByDistance(Cars cars) {
		cars.value().sort(Comparator.comparingInt((Car car) -> car.distance().value()).reversed());
	}

	/**
	 * @author : yh22953905
	 * @Date : 2021/10/12 1:18 오전
	 * @Description : 정렬된 자동차들을 토대로 최종 우승자들을 선별
	 *
	 **/
	private void pickWinners(Cars cars) {
		int winnerDistance = 0;

		for (Car car : cars.value()) {
			if (winnerDistance > car.distance().value()) {
				break;
			}
			winnerDistance = car.distance().value();
			winners.add(car);
		}
	}
}

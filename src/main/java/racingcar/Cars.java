package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {
	private List<Car> cars;

	public Cars(List<Car> cars) {
		this.cars = cars;
	}

	public List<Car> findWinners() {
		Collections.sort(cars);
		int distance = cars.get(0).getCarDistance();
		List<Car> winners = new ArrayList<>();
		for (Car car : cars) {
			if (car.getCarDistance() == distance) {
				winners.add(car);
			}
		}

		return winners;
	}

}

package racingcar.dto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameResult {
	private List<CarStatus> cars;

	public GameResult() {
		cars = new ArrayList<>();
	}

	public GameResult(List<CarStatus> cars) {
		this.cars = cars;
	}

	public void add(CarStatus carStatus) {
		cars.add(carStatus);
	}

	public List<String> getNames() {
		List<String> names = new ArrayList<>();

		for(CarStatus car: cars) {
			names.add(car.getName());
		}

		return names;
	}

	public List<CarStatus> getCars() {
		return Collections.unmodifiableList(cars);
	}
}

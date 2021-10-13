package racinggame.domain;

import java.util.ArrayList;
import java.util.List;

import racinggame.strategy.MovingStrategy;

public class Cars {
	private List<Car> cars;

	public Cars(List<Car> cars) {
		this.cars = cars;
	}

	public void race(MovingStrategy strategy) {
		for (Car car : cars) {
			car.move(strategy);
		}
	}

	public List<CarDto> report() {
		List<CarDto> dtos = new ArrayList<>();
		for (Car car : cars) {
			dtos.add(car.toDto());
		}
		return dtos;
	}
}

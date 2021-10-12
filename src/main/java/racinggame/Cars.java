package racinggame;

import java.util.ArrayList;
import java.util.List;

import racinggame.strategy.MovingStrategy;

public class Cars {
	private List<Car> cars;

	public Cars(List<Car> cars) {
		this.cars = cars;
	}

	public void run(MovingStrategy strategy) {
		for (Car car : cars) {
			car.move(strategy);
		}
	}

	public List<CarDto> report() {
		List<CarDto> carDtos = new ArrayList<>();
		for (Car car : cars) {
			carDtos.add(car.toDto());
		}
		return carDtos;
	}
}

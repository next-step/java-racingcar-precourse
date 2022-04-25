package racingcar.model;

import java.util.List;

import racingcar.GameUtils;

public class Cars {
	private List<Car> cars;

	public Cars(List<Car> cars) {
		this.cars = cars;
	}

	public List<Car> getCars() {
		return cars;
	}
	
	public void move() {
		for(Car car: cars) {
			car.move(randomCarStatus());
		}
	}
	
	private CarStatus randomCarStatus() {
		return GameUtils.getCarStatus(GameUtils.pickNumberInRange());
	}
}

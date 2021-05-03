package racingcar;

import java.util.List;

public class CarResult {

	public void progressGameCount(List<Car> cars) {
		for (Car car : cars) {
			car.printName();
			car.printCurrentPosition();
			moveCar(car, Generator.randomNumber());
		}
	}

	public void moveCar(Car car, int randomNumber) {
		CarStatus result = car.isForward(randomNumber);
		if (result.isGo()) {
			car.forwardPosition();
			System.out.println("-");
		}
		if (result.isStop()) {
			System.out.println();
		}
	}
}

package racinggame.domain;

import java.util.ArrayList;
import java.util.List;

import racinggame.message.ErrorMessage;

public class Cars {
	private final List<Car> cars;

	public Cars() {
		cars = new ArrayList<>();
	}

	public void addCar(Car car) {
		validateCar(car);
		cars.add(car);
	}

	private void validateCar(Car car) {
		if (car == null) {
			throw new NullPointerException();
		}

		for (int i = 0; i < cars.size(); i++) {
			checkSameCarName(car.getName(), cars.get(i));
		}
	}

	private void checkSameCarName(String carName, Car car) {
		if (car.getName().equals(carName)) {
			throw new IllegalArgumentException(ErrorMessage.SAME_CAR_NAME.name());
		}
	}

	public int getQuantity() {
		return cars.size();
	}

	public CarStatus getCarStatusByIndex(int index) {
		return new CarStatus(cars.get(index));
	}

	public void moveCars() {
		for (int i = 0; i < cars.size(); i++) {
			cars.get(i).goForward();
		}
	}
}

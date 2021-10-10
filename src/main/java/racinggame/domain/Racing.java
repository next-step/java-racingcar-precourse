package racinggame.domain;

import java.util.List;

import racinggame.common.ErrorMessage;

public class Racing {

	public static final int GO_VALUE = 4;
	List<Car> carList;

	public void add(Car car) {
		carList.add(car);
	}

	public List<Car> getCarList() {
		return carList;
	}

	public boolean isGo(int value) {
		checkValue(value);
		return value > GO_VALUE;
	}

	private void checkValue(int value) {
		if (value < 0 || value > 9) {
			throw new IllegalArgumentException(ErrorMessage.ERROR_GO_INPUT);
		}
	}

	public void race(Car car, int value) {
		if (isGo(value)) {
			car.go();
		}
	}
}

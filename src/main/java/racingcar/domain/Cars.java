package racingcar.domain;

import java.util.List;

import org.junit.platform.commons.util.ToStringBuilder;

public class Cars {
	private final List<Car> cars;

	public Cars(final List<Car> cars) {
		this.cars = cars;
	}

	public void move() {
		for (Car car : cars) {
			car.move();
		}
	}

	public List<Car> getCars() {
		return cars;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this)
			.append("cars", cars.toString())
			.toString();
	}
}

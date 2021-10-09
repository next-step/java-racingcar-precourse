package racinggame.domain;

import java.util.Iterator;
import java.util.List;

public class Cars implements Iterable<Car> {
	private final List<Car> cars;

	public Cars(List<Car> cars) {
		this.cars = cars;
		checkCarsSize();
		if (cars.size() >= 2) {
			checkSameName();
		}
	}

	public List<Car> getCars() {
		return cars;
	}

	public Car get(int index) {
		return cars.get(index);
	}

	public int size() {
		return cars.size();
	}

	public void move() {
		for (Car car : cars) {
			car.move();
		}
	}

	private void checkCarsSize() {
		if (cars == null || cars.size() <= 0) {
			throw new IllegalArgumentException("자동차를 한 대 이상 등록해주세요");
		}
	}

	private void checkSameName() {
		for (int i = 0; i < cars.size(); i++) {
			checkSameName(cars.get(i), cars.get((i + 1) % cars.size()));
		}
	}

	private void checkSameName(Car car, Car nextCar) {
		if (car.getName().equals(nextCar.getName())) {
			throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
		}
	}

	@Override
	public Iterator<Car> iterator() {
		return cars.iterator();
	}
}

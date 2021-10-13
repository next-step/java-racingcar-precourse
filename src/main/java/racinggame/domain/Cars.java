package racinggame.domain;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Cars implements Iterable<Car> {
	private final List<Car> cars;

	public Cars(List<Car> cars) {
		this.cars = cars;
		checkCarsSize();
		if (cars.size() >= 2) {
			checkSameName();
		}
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
		Set<Car> carSet = new HashSet<>(cars);
		if (carSet.size() != cars.size()) {
			throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
		}
	}

	@Override
	public Iterator<Car> iterator() {
		return cars.iterator();
	}
}

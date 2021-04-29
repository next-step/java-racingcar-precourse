package car;

import java.util.Collections;
import java.util.List;

public class Cars {
	public static final int MAX_CAR_NAME_LENGTH = 5;
	private List<Car> cars;

	public Cars(List<Car> cars) {
		this.cars = cars;
		validateCarNameLength();
	}

	public List<Car> getCarList() {
		return Collections.unmodifiableList(cars);
	}

	public void validateCarNameLength() {
		for (int i = 0; i < cars.size(); i++) {
			Car car = cars.get(i);
			String carName = car.getName();
			if (carName.length() > MAX_CAR_NAME_LENGTH) {
				throw new IllegalArgumentException("자동차의 이름은 5자 이내로 가능합니다.");
			}
		}
	}
}

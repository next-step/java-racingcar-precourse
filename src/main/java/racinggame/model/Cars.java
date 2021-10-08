package racinggame.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import nextstep.utils.Randoms;

public class Cars {

	private static final String REGEX = ",";
	private static final String CHECK_DUPLICATION_ERROR_MESSAGE = "중복되는 자동차 이름이 존재 합니다.";
	private static final int ZERO_POINT = 0;
	private static final int START_INCLUSIVE = 0;
	private static final int END_INCLUSIVE = 9;

	private final List<Car> cars;

	public Cars(List<Car> cars) {
		this.cars = cars;
	}

	public Cars(String name) {
		String[] carsName = toSplit(name);
		checkDuplication(carsName);
		cars = toList(carsName);
	}

	private String[] toSplit(String carNames) {
		return carNames.split(REGEX);
	}

	private List<Car> toList(String[] carNames) {
		List<Car> cars = new ArrayList<>();
		for (String carName : carNames) {
			cars.add(new Car(carName));
		}
		return cars;
	}

	private void checkDuplication(String[] carsName) {
		if (isSameName(carsName)) {
			throw new IllegalArgumentException(CHECK_DUPLICATION_ERROR_MESSAGE);
		}
	}

	private boolean isSameName(String[] carsName) {
		boolean isExist = false;
		for (int index = ZERO_POINT; index < carsName.length; index++) {
			isExist = isSameName(isExist, index, carsName);
		}
		return isExist;
	}

	private boolean isSameName(boolean isExist, int index, String[] carsName) {
		for (int subIndex = ZERO_POINT; subIndex < index; subIndex++) {
			isExist = compareName(isExist, carsName[index], carsName[subIndex]);
		}
		return isExist;
	}

	private boolean compareName(boolean isExist, String name, String subName) {
		if (new Car(name).equals(new Car(subName))) {
			isExist = true;
		}
		return isExist;
	}

	public List<Car> racing() {
		for (Car car : cars) {
			car.racing(Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE));
		}
		return Collections.unmodifiableList(cars);
	}

	public int maxDistance() {
		int maxDistance = ZERO_POINT;
		for (Car car : cars) {
			maxDistance = findMaxDistance(maxDistance, car);
		}
		return maxDistance;
	}

	private int findMaxDistance(int maxDistance, Car car) {
		return Math.max(maxDistance, car.getDistance());
	}

	public List<Car> getCars() {
		return cars;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Cars cars1 = (Cars)o;
		return Objects.equals(cars, cars1.cars);
	}

	@Override
	public int hashCode() {
		return Objects.hash(cars);
	}

}

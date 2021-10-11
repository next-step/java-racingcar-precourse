package racinggame.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

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

	private void checkDuplication(String[] carNames) {
		if (isContainsSameName(carNames)) {
			throw new IllegalArgumentException(CHECK_DUPLICATION_ERROR_MESSAGE);
		}
	}

	private boolean isContainsSameName(String[] carNames) {
		Set<String> checkNames = new HashSet<>(Arrays.asList(carNames));
		return carNames.length != checkNames.size();
	}

	public List<Car> racing() {
		for (Car car : cars) {
			car.racing(Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE));
		}
		return Collections.unmodifiableList(cars);
	}

	public List<Car> findWinnerCars() {
		List<Car> list = new ArrayList<>();
		for (Car car : cars) {
			addWinnerCar(list, car);
		}
		return list;
	}

	private void addWinnerCar(List<Car> list, Car car) {
		if (car.isMaxDistance(maxDistance())) {
			list.add(car);
		}
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

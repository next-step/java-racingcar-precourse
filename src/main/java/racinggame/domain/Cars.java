package racinggame.domain;

import java.util.HashSet;
import java.util.List;

import racinggame.message.ErrorMessage;

public class Cars {
	private final List<Car> cars;

	public Cars(List<Car> cars) {
		validateCars(cars);
		this.cars = cars;
	}

	private void validateCars(List<Car> cars) {
		if (cars == null) {
			throw new NullPointerException();
		}

		if (cars.contains(null)) {
			throw new NullPointerException();
		}

		checkDuplicateCarNames(cars);
	}

	private void checkDuplicateCarNames(List<Car> cars) {
		HashSet<String> carNameSet = new HashSet<>();
		for (int i = 0; i < cars.size(); i++) {
			carNameSet.add(cars.get(i).getName());
		}
		if (cars.size() != carNameSet.size()) {
			throw new IllegalArgumentException(ErrorMessage.DUPLICATE_CAR_NAMES.name());
		}
	}

	private void checkDuplicateCarNames(String carName, Car car) {
		if (car.getName().equals(carName)) {
			throw new IllegalArgumentException(ErrorMessage.DUPLICATE_CAR_NAMES.name());
		}
	}

	public int getCarsCount() {
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

	// public ArrayList<Integer> getWinnerIndexes() {
	// 	ArrayList<Integer> winnerIndexes = new ArrayList<>();
	// 	int maxCarPosition = getMaxCarPosition();
	// 	for (int i = 0; i < cars.size(); i++) {
	//
	// 	}
	// 	return null;
	// }
	//
	// private int getMaxCarPosition() {
	// 	int maxCarPosition = 0;
	// 	for (int i = 0; i < cars.size(); i++) {
	// 		maxCarPosition = maxCarPosition < cars.get(i).getPosition() ? cars.get(i).getPosition() : maxCarPosition;
	// 	}
	// 	return maxCarPosition;
	// }
}

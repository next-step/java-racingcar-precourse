package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {
	private List<Car> cars;

	public Cars(String[] carNames) {
		validateCarNamesIsNotNull(carNames);
		validateCarNamesIsNotZeroLength(carNames);

		List<Car> cars = new ArrayList<>();
		for (String carName : carNames) {
			cars.add(new Car(carName));
		}

		this.cars = cars;
	}

	public Cars(List<Car> cars) {
		this.cars = cars;
	}

	private void validateCarNamesIsNotNull(String[] carNames) {
		if (carNames == null) {
			throw new IllegalArgumentException("NULL은 불가능합니다.");
		}
	}

	private void validateCarNamesIsNotZeroLength(String[] carNames) {
		if (carNames.length == 0) {
			throw new IllegalArgumentException("크기가 0인 배열은 불가능합니다.");
		}
	}

	public void moveCars(int[] randomNumbers) {
		int size = cars.size();

		for (int i = 0; i < size; i++) {
			cars.get(i).move(randomNumbers[i]);
		}
	}

	public List<String> findWinners() {
		Collections.sort(cars);
		int distance = cars.get(0).getCarDistance();
		List<String> winnerNames = new ArrayList<>();
		for (Car car : cars) {
			if (car.getCarDistance() == distance) {
				winnerNames.add(car.getCarName());
			}
		}

		return winnerNames;
	}

	public void printCarsStatus() {
		for (Car car : cars) {
			car.printCarStatus();
		}
		System.out.println();
	}


	public int getCarsLength(){
		return cars.size();
	}

}

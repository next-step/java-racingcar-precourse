package racing.game.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
	List<Car> carList;

	public Cars() {
		carList = new ArrayList<>();
	}

	public Cars(List<String> carNames) {
		carList = new ArrayList<>();
		registCars(carNames);

		setCarsInitPosition();
	}

	public int size() {
		return carList.size();
	}

	public void add(Car car) {
		carList.add(car);
	}

	private void setCarsInitPosition() {
		for (Car car : carList) {
			car.setInitPosition();
		}
	}

	public void runLab() {
		for (Car car : carList) {
			car.movePosition();
		}
	}

	public void showLabStatus() {
		for (Car car : carList) {
			System.out.println(car.getResultGraph());
		}
		System.out.println("");
	}

	public void registCars(List<String> carNames) {
		for (String carName : carNames) {
			carList.add(new Car(carName));
		}
	}

	public int getWinnerPosition() {
		int winnerPosition = 0;
		for (Car car : carList) {
			winnerPosition = comparePosition(winnerPosition, car);
		}
		return winnerPosition;
	}

	private int comparePosition(int winnerPosition, Car car) {
		if (car.getPosition() > winnerPosition){
			winnerPosition = car.getPosition();
		}
		return winnerPosition;
	}

	public List<Car> getWinnerCars() {
		List<Car> winnerCars = new ArrayList<>();
		int winnerPosition = getWinnerPosition();
		for (Car car : carList) {
			addWinnerCar(winnerCars, winnerPosition, car);
		}
		return winnerCars;
	}

	private void addWinnerCar(List<Car> winnerCar, int winnerPosition, Car car) {
		if (car.getPosition() == winnerPosition) {
			winnerCar.add(car);
		}
	}
}

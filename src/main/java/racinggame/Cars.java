package racinggame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {
	List<Car> cars;

	public Cars(Car car) {
		this.cars = Collections.singletonList(car);
	}

	public Cars(List<Car> cars) {
		this.cars = cars;
	}

	public static Cars createByNames(String nameStr) {
		String[] names = nameStr.split(",");
		List<Car> carList = new ArrayList<>();
		for (String name : names) {
			carList.add(new Car(name));
		}
		return new Cars(carList);
	}

	public boolean isEmpty() {
		return this.cars.isEmpty();
	}

	public void play() {
		for (Car car : cars) {
			car.play();
		}
	}

	public Car get(int index) {
		return cars.get(index);
	}

	private void addSamePositionCars(int position, Car currentCar, List<Car> cars) {
		if (currentCar.getPosition() == position) {
			cars.add(currentCar);
		}
	}

	private List<Car> getSpecificPositionCars(int position) {
		List<Car> specificPositionCars = new ArrayList<>();
		for (Car car: cars) {
			addSamePositionCars(position, car, specificPositionCars);
		}
		return specificPositionCars;
	}

	private int getMaxPosition() {
		int maxValue = 0;
		for (Car car : cars) {
			maxValue = Math.max(car.getPosition(), maxValue);
		}
		return maxValue;
	}

	public List<Car> getWinners() {
		int maxPosition = getMaxPosition();
		return getSpecificPositionCars(maxPosition);
	}
}

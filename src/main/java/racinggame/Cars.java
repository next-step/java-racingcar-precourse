package racinggame;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Cars {
	private final List<Car> cars = new ArrayList<>();

	public Cars(CarNames carNames) {
		for (CarName carName : carNames.getAll()) {
			cars.add(new Car(carName));
		}
	}

	public int size() {
		return cars.size();
	}

	public void race() {
		for (Car car : cars) {
			car.race();
		}
	}

	public CarNames getWinnerNames() {
		sort();

		int idx = getIndexOfCarsHasSameStateAsWinner(cars.get(0));
		List<Car> cars = this.cars.subList(0, idx + 1);

		return mapToCarNames(cars);
	}

	private CarNames mapToCarNames(List<Car> cars) {
		List<CarName> carNames = new ArrayList<>();
		for (Car car : cars) {
			carNames.add(car.getCarName());
		}

		return new CarNames(carNames);
	}

	private int getIndexOfCarsHasSameStateAsWinner(Car winner) {
		int idx = 0;
		while (winner.hasSameStateAs(cars.get(idx))) {
			++idx;
		}

		return idx-1;
	}

	private void sort() {
		cars.sort((c1, c2) -> new CarComparator().compare(c1, c2));
	}
}

class CarComparator implements Comparator<Car> {

	@Override
	public int compare(Car c1, Car c2) {
		return c2.subtractRacingState(c1);
	}
}
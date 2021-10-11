package racinggame;

import java.util.ArrayList;
import java.util.List;

import nextstep.utils.Randoms;

public class Cars {

	private static final int MIN_NUMBER = 0;
	private static final int MAX_NUMBER = 9;
	private final List<Car> racers;

	public Cars(List<String> names) {
		this.racers = initialize(names);
	}

	private List<Car> initialize(List<String> names) {
		List<Car> cars = new ArrayList<>();
		for (String name : names) {
			cars.add(new Car(name));
		}
		return cars;
	}

	public int getNumberOfCars() {
		return racers.size();
	}

	public void race(int number) {
		do {
			racing();
		} while (number-- > 0);
	}

	private void racing() {
		for (Car car : this.racers) {
			car.race(Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER));
			car.printCarResults();
		}
	}
}

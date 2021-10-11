package racinggame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cars {
	private final List<Car> cars = new ArrayList<>();

	public Cars(String... carNames) {
		validateDuplicatedNames(Arrays.asList(carNames));

		for (String carName : carNames) {
			cars.add(new Car(carName));
		}
	}

	public int size() {
		return cars.size();
	}

	private void validateDuplicatedNames(List<String> carNames) {
		Set<String> nameSet = new HashSet<>(carNames);

		if (nameSet.size() != carNames.size()) {
			throw new IllegalArgumentException("중복된 이름은 사용할 수 없습니다");
		}
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
		return new CarNames(cars);
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
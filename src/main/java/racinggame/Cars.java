package racinggame;

import java.util.ArrayList;
import java.util.Arrays;
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

	public ProgressBars getProgressBars() {
		List<ProgressBar> progressBars = new ArrayList<>();
		for (Car car : cars) {
			progressBars.add(car.getProgressBar());
		}

		return new ProgressBars(progressBars);
	}
}

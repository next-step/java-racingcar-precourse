package racinggame.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import racinggame.exception.DuplicatedCarNameException;
import racinggame.functional.ForwardMoveRule;

public class Cars {
	private final List<Car> values;

	public Cars(List<Car> values) {
		checkDuplicatedCarName(values);
		this.values = Collections.unmodifiableList(values);
	}

	public static Cars createEmptyCars() {
		return new Cars(Collections.emptyList());
	}

	public Cars startRace(ForwardMoveRule forwardMoveRule) {
		List<Car> cars = new ArrayList<>();
		for (Car car : values) {
			cars.add(car.moveOrStop(forwardMoveRule));
		}

		return new Cars(cars);
	}

	public List<Name> getCarNames() {
		List<Name> names = new ArrayList<>(values.size());
		for (Car car : values) {
			names.add(car.getName());
		}
		return names;
	}

	public Cars add(Car car) {
		List<Car> copiedValues = new ArrayList<>(values);
		copiedValues.add(car);
		return new Cars(copiedValues);
	}

	private void checkDuplicatedCarName(List<Car> values) {
		if (isDuplicatedName(values)) {
			throw new DuplicatedCarNameException();
		}
	}

	private boolean isDuplicatedName(List<Car> values) {
		Set<Name> carNames = new HashSet<>();
		for (Car car : values) {
			carNames.add(car.getName());
		}
		return values.size() != carNames.size();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Cars cars = (Cars)o;
		return Objects.equals(values, cars.values);
	}

	@Override
	public int hashCode() {
		return Objects.hash(values);
	}

	@Override
	public String toString() {
		return "Cars{" +
			"values=" + values +
			'}';
	}
}

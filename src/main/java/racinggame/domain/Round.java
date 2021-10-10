package racinggame.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import racinggame.functional.ForwardMoveRule;

public class Round {
	private final List<Car> values;

	public Round(List<Car> values) {
		this.values = Collections.unmodifiableList(values);
	}

	public Round startRacingCars(ForwardMoveRule forwardMoveRule) {
		List<Car> cars = new ArrayList<>();
		for (Car car : values) {
			cars.add(car.moveOrStop(forwardMoveRule));
		}

		return new Round(cars);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Round round = (Round)o;
		return Objects.equals(values, round.values);
	}

	@Override
	public int hashCode() {
		return Objects.hash(values);
	}

	@Override
	public String toString() {
		return "Round{" +
			"values=" + values +
			'}';
	}
}

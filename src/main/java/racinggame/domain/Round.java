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

	public Round raceCars(ForwardMoveRule gameRule) {
		List<Car> result = new ArrayList<>();
		for (Car car : this.values) {
			result.add(moveOrStopOfCar(gameRule, car));
		}

		return new Round(result);
	}

	private Car moveOrStopOfCar(ForwardMoveRule gameRule, Car car) {
		if (gameRule.isMovable()) {
			return car.move();
		}

		return car;
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

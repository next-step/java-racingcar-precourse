package racinggame.domain;

import java.util.List;
import java.util.Objects;

import racinggame.functional.ForwardMoveRule;
import racinggame.functional.RandomForwardMoveRule;

public class Round {
	private final Cars cars;
	private final RaceCount raceCount;

	public Round(Cars cars, RaceCount raceCount) {
		this.cars = cars;
		this.raceCount = raceCount;
	}

	public Round startRacingCars() {
		ForwardMoveRule forwardMoveRule = new RandomForwardMoveRule();
		return new Round(cars.startRace(forwardMoveRule), raceCount.decrease());
	}

	public boolean isRemainingCount() {
		return raceCount.isRemainingCount();
	}

	public List<Car> getCars() {
		return cars.getValues();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Round that = (Round)o;
		return raceCount == that.raceCount && Objects.equals(cars, that.cars);
	}

	@Override
	public int hashCode() {
		return Objects.hash(cars, raceCount);
	}

	@Override
	public String toString() {
		return "RacingGame{" +
			"cars=" + cars +
			", raceCount=" + raceCount +
			'}';
	}
}

package racinggame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import racinggame.functional.ForwardMoveRule;
import racinggame.functional.RandomForwardMoveRule;

public class Round {
	private final Cars cars;
	private final RaceCount raceCount;

	private Round(Cars cars, int count) {
		this(cars, new RaceCount(count));
	}

	private Round(Cars cars, RaceCount raceCount) {
		this.cars = cars;
		this.raceCount = raceCount;
	}

	public static Round createNew(String carNames, int count) {
		List<Car> carList = new ArrayList<>();
		String[] names = carNames.split(",");
		for (String name : names) {
			carList.add(new Car(name));
		}

		return new Round(new Cars(carList), count);
	}

	public Round startRacingCars() {
		ForwardMoveRule forwardMoveRule = new RandomForwardMoveRule();
		return new Round(cars.startRace(forwardMoveRule), raceCount.decrease());
	}

	public boolean isRemainingCount() {
		return raceCount.isRemainingCount();
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

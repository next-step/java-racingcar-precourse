package racinggame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import racinggame.exception.UnsatisfiedMinimumValueException;
import racinggame.functional.ForwardMoveRule;
import racinggame.functional.RandomForwardMoveRule;

public class Round {
	private static final int MIN_OF_ROUND_COUNT = 0;

	private final Cars cars;
	private final int count;

	private Round(Cars cars, int count) {
		checkValidRaceCountValue(count);
		this.cars = cars;
		this.count = count;
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
		return new Round(cars.startRace(forwardMoveRule), count - 1);
	}

	public boolean isRemainingCount() {
		return count > MIN_OF_ROUND_COUNT;
	}

	private void checkValidRaceCountValue(int count) {
		if (count < MIN_OF_ROUND_COUNT) {
			throw new UnsatisfiedMinimumValueException(MIN_OF_ROUND_COUNT);
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Round that = (Round)o;
		return count == that.count && Objects.equals(cars, that.cars);
	}

	@Override
	public int hashCode() {
		return Objects.hash(cars, count);
	}

	@Override
	public String toString() {
		return "RacingGame{" +
			"cars=" + cars +
			", raceCount=" + count +
			'}';
	}
}

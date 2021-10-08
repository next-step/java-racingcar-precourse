package racinggame.model;

import java.util.List;
import java.util.Objects;

public class RacingGame {

	private final Cars cars;
	private final TryCount tryCount;

	public RacingGame(Cars cars, TryCount tryCount) {
		this.cars = cars;
		this.tryCount = tryCount;
	}

	public boolean isNotFinish() {
		return tryCount.isNotFinish();
	}

	public List<Car> racing() {
		addRaceTryNumber();
		return cars.racing();
	}

	private void addRaceTryNumber() {
		tryCount.tryRacing();
	}

	public List<Car> findWinnerCars() {
		return cars.findWinnerCars();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		RacingGame that = (RacingGame)o;
		return Objects.equals(cars, that.cars) && Objects.equals(tryCount, that.tryCount);
	}

	@Override
	public int hashCode() {
		return Objects.hash(cars, tryCount);
	}

}

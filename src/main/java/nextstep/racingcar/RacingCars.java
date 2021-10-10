package nextstep.racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import nextstep.constants.CommonConstants;

public class RacingCars {

	private final List<RacingCar> racingCars;

	public RacingCars(List<RacingCar> racingCars) {
		this.racingCars = racingCars;
	}

	public Position getGreatestPosition() {
		Position greatestPosition = new Position();

		for (RacingCar racingCar : racingCars) {
			greatestPosition = racingCar.getGreaterPosition(greatestPosition);
		}

		return greatestPosition;
	}

	public RacingCars move() {
		List<RacingCar> movedCars = new ArrayList<>();

		for (RacingCar racingCar : racingCars) {
			movedCars.add(racingCar.move());
		}

		return new RacingCars(movedCars);
	}

	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder();

		for (RacingCar racingCar : racingCars) {
			builder.append(racingCar.toString()).append(CommonConstants.NEWLINE);
		}

		return builder.toString();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		RacingCars that = (RacingCars)o;
		return Objects.equals(racingCars, that.racingCars);
	}

	@Override
	public int hashCode() {
		return Objects.hash(racingCars);
	}
}

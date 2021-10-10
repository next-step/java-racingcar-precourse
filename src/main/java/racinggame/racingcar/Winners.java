package racinggame.racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

import racinggame.constants.CommonConstants;

public class Winners {

	private final List<RacingCar> winners;

	public Winners(List<RacingCar> winners) {
		this.winners = winners;
	}

	public static Winners getWinners(RacingCars racingCars) {
		final Position position = racingCars.getGreatestPosition();

		final List<RacingCar> winners = new ArrayList<>();
		for (RacingCar racingCar : racingCars.getRacingCars()) {
			addWinner(winners, racingCar, position);
		}

		return new Winners(winners);
	}

	private static void addWinner(List<RacingCar> winners, RacingCar racingCar, Position position) {
		if (racingCar.hasSamePosition(position)) {
			winners.add(racingCar);
		}
	}

	@Override
	public String toString() {
		final StringJoiner joiner = new StringJoiner(CommonConstants.COMMA);

		for (RacingCar winner : winners) {
			joiner.add(winner.getName());
		}

		return joiner.toString();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Winners winners1 = (Winners)o;
		return Objects.equals(winners, winners1.winners);
	}

	@Override
	public int hashCode() {
		return Objects.hash(winners);
	}
}

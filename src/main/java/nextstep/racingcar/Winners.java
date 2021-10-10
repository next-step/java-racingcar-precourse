package nextstep.racingcar;

import java.util.List;
import java.util.StringJoiner;

import nextstep.constants.CommonConstants;

public class Winners {

	private final List<RacingCar> winners;

	public Winners(List<RacingCar> winners) {
		this.winners = winners;
	}

	@Override
	public String toString() {
		final StringJoiner joiner = new StringJoiner(CommonConstants.COMMA);

		for (RacingCar winner : winners) {
			joiner.add(winner.getName());
		}

		return joiner.toString();
	}
}

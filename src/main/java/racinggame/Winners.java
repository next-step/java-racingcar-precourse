package racinggame;

import java.util.LinkedList;
import java.util.List;
import java.util.StringJoiner;

public class Winners {
	private final Position winPosition;
	private List<RacingCar> winners;

	public Winners(Position position) {
		this.winPosition = position;
		this.winners = new LinkedList<>();
	}

	public void addWinner(RacingCar car) {
		if (this.winPosition.equals(car.getPosition())) {
			this.winners.add(car);
		}
	}

	@Override
	public String toString() {
		StringJoiner joiner = new StringJoiner(",");
		for (RacingCar winner : winners) {
			joiner.add(winner.getName());
		}
		return joiner.toString();
	}
}

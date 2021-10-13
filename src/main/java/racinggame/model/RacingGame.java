package racinggame.model;

import java.util.List;

public class RacingGame {
	private final ParticipationCars participationCars;

	public RacingGame(final List<String> names) {
		participationCars = new ParticipationCars();
		ready(names);
	}

	public void start(final int tryNumber) {
		for (int i = 0; i < tryNumber; i++) {
			participationCars.startRound();
		}
	}

	private void ready(final List<String> names) {
		for (String name : names) {
			participationCars.enterRace(new Car(name));
		}
	}
}

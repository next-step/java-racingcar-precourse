package racinggame.model;

import java.util.List;

public class RacingGame {
	private final ParticipationCars participationCars;

	public RacingGame(final List<String> names) {
		participationCars = new ParticipationCars();
		ready(names);
	}

	public RaceResult start(final int tryNumber) {
		RaceResult raceResult = new RaceResult();
		for (int i = 0; i < tryNumber; i++) {
			RoundResult roundResult = participationCars.startRound();
			raceResult.appendRoundResult(roundResult.getRoundResultStr());
		}
		raceResult.appendWinner(getWinner());
		return raceResult;
	}

	private Winner getWinner() {
		return participationCars.createWinner();
	}

	private void ready(final List<String> names) {
		for (String name : names) {
			participationCars.enterRace(new Car(name));
		}
	}
}

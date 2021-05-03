package io.github.redlasha.racingcar;

import java.util.List;

public class RacingGame {

	private CarEntries entries;
	private RacingTurn turn;
	private RandomNumbersGeneratable randomGenerator;

	public RacingGame(CarEntries entries, RacingTurn turn, RandomNumbersGeneratable randomGenerator) {
		this.entries = entries;
		this.turn = turn;
		this.randomGenerator = randomGenerator;
	}

	public void start() {
		while (turn.next()) {
			entries.moveTurn(randomGenerator.nextNumberList(entries.size()));
		}
	}

	public List<Car> matchResult() {
		return entries.getWinners();
	}

}

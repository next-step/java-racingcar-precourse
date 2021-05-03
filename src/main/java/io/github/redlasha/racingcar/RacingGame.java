package io.github.redlasha.racingcar;

import java.io.PrintStream;
import java.util.List;

public class RacingGame {

	private CarEntries entries;
	private RacingTurn turn;
	private RandomNumbersGeneratable randomGenerator;
	private PrintStream printStream;

	public RacingGame(CarEntries entries, RacingTurn turn, RandomNumbersGeneratable randomGenerator, PrintStream out) {
		this.entries = entries;
		this.turn = turn;
		this.randomGenerator = randomGenerator;
		this.printStream = out;
	}

	public void start() {
		while (turn.next()) {
			entries.moveTurn(randomGenerator.nextNumberList(entries.size()));
			String status = entries.currentStatus();
			printStream.println(status);
		}
	}

	public List<Car> matchResult() {
		return entries.getWinners();
	}

}

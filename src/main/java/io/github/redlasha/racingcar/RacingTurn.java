package io.github.redlasha.racingcar;

public class RacingTurn {

	private int turn;

	public RacingTurn(int turn) {
		if (turn <= 0) {
			throw new IllegalArgumentException("Turn must be positive integer.");
		}
		this.turn = turn;
	}

	public boolean next() {
		if (turn > 0) {
			turn--;
			return true;
		}
		return false;
	}
}

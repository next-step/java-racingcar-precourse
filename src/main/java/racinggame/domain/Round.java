package racinggame.domain;

public class Round {

	private int round;

	public Round(int round) {
		this.round = round;
	}

	public void nextRound() {
		this.round -= 1;
	}

	public boolean isEnd() {
		return this.round == 0;
	}
}

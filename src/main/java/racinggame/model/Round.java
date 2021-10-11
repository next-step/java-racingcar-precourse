package racinggame.model;

public class Round {
	private int round;

	public Round(int round) {
		this.round = round;
	}

	public int getRound() {
		return round;
	}

	public void nextRound() {
		round--;
	}

	public boolean isFinalRound() {
		return round == 0;
	}
}

package racinggame.model;

public class Round {
	public static final int FINAL_ROUND = 0;
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
		return round == FINAL_ROUND;
	}
}

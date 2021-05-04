package domain;

import view.OutputView;

public class RacingPosition {
	private static final int START_POSITION = 0;
	private static final int MOVE_STANDARD = 4;
	private int position;

	public RacingPosition() {
		this.position = START_POSITION;
	}

	public int getPosition() {
		return position;
	}

	public void move(int randomNumber) {
		if (randomNumber >= MOVE_STANDARD)
			this.position++;
	}

	public void printPosition() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < position; i++) {
			sb.append("-");
		}
		OutputView.printPosition(sb.toString());
	}
}

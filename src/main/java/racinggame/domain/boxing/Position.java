package racinggame.domain.boxing;

import racinggame.error.InvalidCarPosition;

public class Position {

	private int postion;

	public Position(final int position) {
		validatePosition(position);
		this.postion = position;
	}

	private void validatePosition(int position) {
		if (position < 0) {
			throw new InvalidCarPosition();
		}
	}

	public void movePosition() {
		this.postion++;
	}

	public int getPosition() {
		return this.postion;
	}

}

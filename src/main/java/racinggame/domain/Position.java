package racinggame.domain;

public class Position {

	private static final int START_POSITION_VALUE = 0;

	private int position;

	private Position(int position) {
		this.position = position;
	}

	public static Position init() {
		return new Position(START_POSITION_VALUE);
	}

	public int getPosition() {
		return this.position;
	}

	public void move() {
		position++;
	}
}

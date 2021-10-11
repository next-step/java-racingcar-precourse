package racinggame;

public class Movement {
	private static final int BOUNDARY = 4;
	private final int movement;

	public Movement(int movement) {
		this.movement = movement;
	}

	public boolean isMoved() {
		if (movement >= BOUNDARY) {
			return true;
		}

		return false;
	}
}

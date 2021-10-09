package racinggame.model;

public class Position {

	private static final int INCREASE_POSITION_INDEX = 1;
	private static final int MOVED_INDEX = 4;
	private static final int MOVE_NUMBER_MIN_INDEX = 0;
	private static final int MOVE_NUMBER_MAX_INDEX = 9;
	private static final String MOVE_NUMBER_EXCEPTION_MESSAGE = "입력 값은 0~9 사이여야 합니다.";

	private final int position;

	private Position(int position) {
		this.position = position;
	}

	public static Position valueOf(int position) {
		return new Position(position);
	}

	public int currentPosition() {
		return position;
	}

	public Position move(int moveNumber) {
		if (moveNumber < MOVE_NUMBER_MIN_INDEX || moveNumber > MOVE_NUMBER_MAX_INDEX) {
			throw new IllegalArgumentException(MOVE_NUMBER_EXCEPTION_MESSAGE);
		}
		return new Position(moveAction(this.position, moveNumber));
	}

	private int moveAction(int position, int moveNumber) {
		if (isMoved(moveNumber)) {
			return position + INCREASE_POSITION_INDEX;
		}

		return position;
	}

	private boolean isMoved(int moveNumber) {
		return moveNumber >= MOVED_INDEX;
	}
}

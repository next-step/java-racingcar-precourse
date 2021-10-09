package racinggame.model;

import java.util.Objects;

import racinggame.exception.InvalidPositionException;

public class Position {

	private static final int MIN_POSITION_INDEX = 0;
	private static final String POSITION_NEGATIVE_EXCEPTION_MESSAGE = "포지션은 %d보다 작을 수 없습니다.";
	private static final int INCREASE_POSITION_INDEX = 1;

	private final int position;

	private Position(int position) {
		validatePosition(position);
		this.position = position;
	}

	private void validatePosition(int position) {
		if (position < MIN_POSITION_INDEX) {
			throw new InvalidPositionException(String.format(POSITION_NEGATIVE_EXCEPTION_MESSAGE, MIN_POSITION_INDEX));
		}
	}

	public static Position valueOf(int position) {
		return new Position(position);
	}

	public int currentPosition() {
		return position;
	}

	public Position move() {
		return new Position(moveAction(this.position));
	}

	private int moveAction(int position) {
		return position + INCREASE_POSITION_INDEX;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Position position1 = (Position)o;
		return position == position1.position;
	}

	@Override
	public int hashCode() {
		return Objects.hash(position);
	}
}

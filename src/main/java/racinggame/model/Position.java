package racinggame.model;

import java.util.Objects;

public class Position {

	private static final int INCREASE_POSITION_INDEX = 1;

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

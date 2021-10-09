package nextstep.racingcar;

import java.util.Objects;

public class Position {

	private static final int MINIMUM_REQUIREMENT_FOR_MOVEMENT = 4;
	private static final String DASH = "-";

	private final int position;

	public Position() {
		this(0);
	}

	public Position(int position) {
		this.position = position;
	}

	public Position move(int input) {
		if (input >= MINIMUM_REQUIREMENT_FOR_MOVEMENT) {
			return new Position(position + 1);
		}
		return this;
	}

	public String toString() {
		final StringBuilder builder = new StringBuilder();
		for (int i = 0; i < position; i++) {
			builder.append(DASH);
		}

		return builder.toString();
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

	public boolean finish(int maxPosition) {
		return position == maxPosition;
	}
}

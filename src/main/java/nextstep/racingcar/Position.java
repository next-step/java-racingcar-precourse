package nextstep.racingcar;

import java.util.Objects;

import nextstep.exception.InvalidPositionException;

public class Position {

	private static final int MIN_POSITION = 0;
	private static final String DASH = "-";

	private final int position;

	public Position() {
		this(0);
	}

	public Position(int position) {
		if (invalid(position)) {
			throw new InvalidPositionException();
		}
		this.position = position;
	}

	private boolean invalid(int position) {
		return position < MIN_POSITION;
	}

	public Position move() {
		return new Position(position + 1);
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

}

package racinggame.domain;

import java.util.Objects;

public class Position {
	private static final int DEFAULT_POSITION = 0;

	private int position;

	public Position() {
		this.position = DEFAULT_POSITION;
	}

	public int move() {
		return ++position;
	}

	public int getCurrentPosition() {
		return position;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Position opponent = (Position)o;
		return position == opponent.position;
	}

	@Override
	public int hashCode() {
		return Objects.hash(position);
	}
}
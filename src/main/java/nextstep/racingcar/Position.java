package nextstep.racingcar;

import java.util.Objects;

public class Position {

	private static final int MINIMUM_REQUIREMENT_FOR_MOVEMENT = 4;

	private final int position;

	public Position() {
		this(0);
	}

	public Position(int position) {
		this.position = position;
	}

	public Position move(int input) {
		if(input >= MINIMUM_REQUIREMENT_FOR_MOVEMENT) {
			return new Position(position + 1);
		}
		return this;
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

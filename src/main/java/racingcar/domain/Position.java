package racingcar.domain;

import java.util.Objects;

import org.junit.platform.commons.util.ToStringBuilder;

public class Position {
	private int position;

	public Position() {
		this(0);
	}

	public Position(int position) {
		if (position < 0) {
			throw new IllegalArgumentException("[ERROR] 위치 초기 값은 0 이상이여야 합니다.");
		}
		this.position = position;
	}

	public void move() {
		this.position++;
	}

	public String getPositionToBar() {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < position; i++) {
			builder.append("-");
		}
		return builder.toString();
	}

	public int getPosition() {
		return position;
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

	@Override
	public String toString() {
		return new ToStringBuilder(this)
			.append("position", position)
			.toString();
	}
}

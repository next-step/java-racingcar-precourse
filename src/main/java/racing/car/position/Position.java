package racing.car.position;

import java.util.Objects;

public class Position {
	private int val;

	public Position(int val) {
		this.val = val;
	}

	public int getVal() {
		return this.val;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Position position = (Position)o;
		return val == position.val;
	}

	@Override
	public int hashCode() {
		return Objects.hash(val);
	}
}

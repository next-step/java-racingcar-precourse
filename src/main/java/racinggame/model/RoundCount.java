package racinggame.model;

import java.util.Objects;

public class RoundCount {

	private static final int DECREASE_SIZE = 1;

	private final int count;

	public RoundCount(int count) {
		this.count = count;
	}

	public int decrease() {
		return count - DECREASE_SIZE;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		RoundCount that = (RoundCount)o;
		return count == that.count;
	}

	@Override
	public int hashCode() {
		return Objects.hash(count);
	}
}

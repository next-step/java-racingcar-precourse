package racinggame.model;

import java.util.Objects;

public class TryCount {

	private static final int ZERO_POINT = 0;

	private final int tryCount;
	private final int racingCount;

	public TryCount(int tryCount) {
		this.tryCount = tryCount;
		this.racingCount = ZERO_POINT;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		TryCount tryCount1 = (TryCount)o;
		return tryCount == tryCount1.tryCount && racingCount == tryCount1.racingCount;
	}

	@Override
	public int hashCode() {
		return Objects.hash(tryCount, racingCount);
	}
}

package racinggame.model;

import java.util.Objects;

public class TryCount {

	private static final String CHECK_MIN_TRY_COUNT_ERROR_MESSAGE = "레이싱회수는 0이하가 될수 없습니다.";
	private static final int ZERO_POINT = 0;

	private final int tryCount;
	private final int racingCount;

	public TryCount(int tryCount) {
		checkMinTryCount(tryCount);
		this.tryCount = tryCount;
		this.racingCount = ZERO_POINT;
	}

	private void checkMinTryCount(int tryCount) {
		if (tryCount <= ZERO_POINT) {
			throw new IllegalArgumentException(CHECK_MIN_TRY_COUNT_ERROR_MESSAGE);
		}
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

package racinggame.model;

import java.util.Objects;

public class TryCount {

	private static final String INT_REG_EXP = "^\\d+$";
	private static final String CHECK_MATCH_TYPE_ERROR_MESSAGE = "레이싱회수는 숫자만 가능 합니다.";
	private static final String CHECK_MIN_TRY_COUNT_ERROR_MESSAGE = "레이싱회수는 0이하가 될수 없습니다.";
	private static final String CHECK_EMPTY_ERROR_MESSAGE = "레이싱회수가 빈값 입니다.";
	private static final String CHECK_NULL_ERROR_MESSAGE = "레이싱회수가 null 입니다.";
	private static final int ZERO_POINT = 0;
	private static final int RACING_COUNT = 1;

	private final int tryCount;
	private int racingCount;

	public TryCount(int tryCount) {
		checkMinTryCount(tryCount);
		this.tryCount = tryCount;
		this.racingCount = ZERO_POINT;
	}

	public TryCount(String tryCount) {
		checkNull(tryCount);
		checkEmpty(tryCount);
		checkMatchType(tryCount);
		this.tryCount = toInt(tryCount);
		this.racingCount = ZERO_POINT;
	}

	private void checkNull(String tryCount) {
		if (tryCount == null) {
			throw new IllegalArgumentException(CHECK_NULL_ERROR_MESSAGE);
		}
	}

	private void checkEmpty(String tryCount) {
		if (tryCount.isEmpty()) {
			throw new IllegalArgumentException(CHECK_EMPTY_ERROR_MESSAGE);
		}
	}

	private void checkMatchType(String tryCount) {
		if (!tryCount.matches(INT_REG_EXP)) {
			throw new IllegalArgumentException(CHECK_MATCH_TYPE_ERROR_MESSAGE);
		}
	}

	private int toInt(String tryCount) {
		int count = Integer.parseInt(tryCount);
		checkMinTryCount(count);
		return count;
	}

	private void checkMinTryCount(int tryCount) {
		if (tryCount <= ZERO_POINT) {
			throw new IllegalArgumentException(CHECK_MIN_TRY_COUNT_ERROR_MESSAGE);
		}
	}

	public int tryRacing() {
		return racingCount += RACING_COUNT;
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

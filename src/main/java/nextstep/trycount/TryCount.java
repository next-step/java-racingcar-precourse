package nextstep.trycount;

import java.util.Objects;

import nextstep.exception.InvalidTryCountException;

public class TryCount {

	private static final int MIN_TRY_COUNT = 0;

	private final int tryCount;

	public TryCount(int tryCount) {
		if (invalid(tryCount)) {
			throw new InvalidTryCountException();
		}
		this.tryCount = tryCount;
	}

	private boolean invalid(int tryCount) {
		return tryCount < MIN_TRY_COUNT;
	}

	public TryCount decrease() {
		final int decreased = tryCount - 1;
		if (invalid(decreased)) {
			throw new InvalidTryCountException();
		}

		return new TryCount(decreased);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		TryCount tryCount1 = (TryCount)o;
		return tryCount == tryCount1.tryCount;
	}

	@Override
	public int hashCode() {
		return Objects.hash(tryCount);
	}
}

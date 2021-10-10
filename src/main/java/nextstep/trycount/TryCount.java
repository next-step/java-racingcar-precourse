package nextstep.trycount;

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
}

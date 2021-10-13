package racinggame.domain;

import static racinggame.common.ErrorMessage.*;

import java.util.regex.Pattern;

public class TryCount {
	private static final String TRY_INPUT_PATTERN = "^[1-9]([0-9])*$";
	public int tryCount;

	public TryCount(String tryCountStr) {
		patternCheck(tryCountStr);
		int tryCount = Integer.parseInt(tryCountStr);
		positiveCheck(tryCount);
		this.tryCount = tryCount;
	}

	public TryCount(int tryCount) {
		positiveCheck(tryCount);
		this.tryCount = tryCount;
	}

	public int getTryCount() {
		return tryCount;
	}

	public void setTryCount(int tryCount) {
		this.tryCount = tryCount;
	}

	private void patternCheck(String input) {
		if (!Pattern.matches(TRY_INPUT_PATTERN, input)) {
			throw new IllegalArgumentException(ERROR_TRY_COUNT);
		}
	}

	private void positiveCheck(int input) {
		if (input <= 0) {
			throw new IllegalArgumentException(ERROR_TRY_COUNT);
		}
	}
}

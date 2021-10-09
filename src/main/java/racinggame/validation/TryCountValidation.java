package racinggame.validation;

import java.util.Objects;

public class TryCountValidation {

	private static final String INT_REG_EXP = "^\\d+$";
	private static final String CHECK_EMPTY_ERROR_MESSAGE = "레이싱횟수가 빈값 입니다.";
	private static final String CHECK_NULL_ERROR_MESSAGE = "레이싱횟수가 null 입니다.";
	private static final String CHECK_MATCH_TYPE_ERROR_MESSAGE = "레이싱회수는 숫자만 가능 합니다.";
	private static final String CHECK_SUITABLE_SIZE_ERROR_MESSAGE = "레이싱회수는 0이하가 될수 없습니다.";
	private static final String EMPTY_MESSAGE = "";
	private static final int ZERO_POINT = 0;

	private final boolean errorStatus;
	private final String message;

	public TryCountValidation() {
		this.errorStatus = false;
		this.message = EMPTY_MESSAGE;
	}

	public TryCountValidation(boolean errorStatus, String message) {
		this.errorStatus = errorStatus;
		this.message = message;
	}

	public TryCountValidation checkInputStatus(String tryCount) {
		if (isNull(tryCount)) {
			return new TryCountValidation(true, CHECK_NULL_ERROR_MESSAGE);
		}
		if (isEmpty(tryCount)) {
			return new TryCountValidation(true, CHECK_EMPTY_ERROR_MESSAGE);
		}
		if (isMatchType(tryCount)) {
			return new TryCountValidation(true, CHECK_MATCH_TYPE_ERROR_MESSAGE);
		}
		if (isSuitableSize(tryCount)) {
			return new TryCountValidation(true, CHECK_SUITABLE_SIZE_ERROR_MESSAGE);
		}
		return new TryCountValidation(false, EMPTY_MESSAGE);
	}

	private boolean isSuitableSize(String tryCount) {
		return Integer.parseInt(tryCount) <= ZERO_POINT;
	}

	private boolean isMatchType(String tryCount) {
		return !tryCount.matches(INT_REG_EXP);
	}

	public boolean isEmpty(String tryCount) {
		return tryCount.isEmpty();
	}

	public boolean isNull(String tryCount) {
		return tryCount == null;
	}

	public boolean isProblem() {
		return errorStatus;
	}

	public String getErrorMessage() {
		return message;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		TryCountValidation that = (TryCountValidation)o;
		return errorStatus == that.errorStatus && Objects.equals(message, that.message);
	}

	@Override
	public int hashCode() {
		return Objects.hash(errorStatus, message);
	}
}

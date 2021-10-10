package racinggame.validation;

public class TryCountValidation extends InputValidation {

	private static final String INT_REG_EXP = "^\\d+$";
	private static final String CHECK_EMPTY_OR_NULL_ERROR_MESSAGE = "레이싱횟수가 빈값 또는 NULL 입니다.";
	private static final String CHECK_MATCH_TYPE_ERROR_MESSAGE = "레이싱회수는 숫자만 가능 합니다.";
	private static final String CHECK_SUITABLE_SIZE_ERROR_MESSAGE = "레이싱회수는 0이하가 될수 없습니다.";
	private static final int ZERO_POINT = 0;

	public TryCountValidation() {
		super();
	}

	public TryCountValidation(boolean errorStatus, String message) {
		super(errorStatus, message);
	}

	@Override
	public TryCountValidation checkInputStatus(String tryCount) {
		if (isEmptyOrIsNull(tryCount)) {
			return new TryCountValidation(true, CHECK_EMPTY_OR_NULL_ERROR_MESSAGE);
		}
		if (isMatchType(tryCount)) {
			return new TryCountValidation(true, CHECK_MATCH_TYPE_ERROR_MESSAGE);
		}
		if (isSuitableSize(tryCount)) {
			return new TryCountValidation(true, CHECK_SUITABLE_SIZE_ERROR_MESSAGE);
		}
		return new TryCountValidation(false, EMPTY_MESSAGE);
	}

	@Override
	public boolean isSuitableSize(String tryCount) {
		return Integer.parseInt(tryCount) <= ZERO_POINT;
	}

	private boolean isMatchType(String tryCount) {
		return !tryCount.matches(INT_REG_EXP);
	}

}

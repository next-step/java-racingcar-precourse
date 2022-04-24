package racingcar.dto.request;

import java.util.Objects;
import racingcar.exception.RacingCarGameException;

public class TryCount {
    private static final String NOTNULL_ERROR = "시도 횟수를 입력해 주세요.";
    private static final String TYPE_ERROR = "시도 횟수는 숫자여야합니다.";

    private final int value;

    private TryCount(String tryCount) {
        this.value = validate(tryCount);
    }

    public static TryCount from(String tryCount) {
        return new TryCount(tryCount);
    }

    public int get() {
        return value;
    }

    private int validate(String tryCount) {
        validateNonNull(tryCount);
        validateNonEmpty(tryCount);
        return validateNumber(tryCount);
    }

    private int validateNumber(String tryCount) {
        try {
            return Integer.parseInt(tryCount);
        } catch (NumberFormatException e) {
            throw illegalArgumentException(TYPE_ERROR);
        }
    }

    private void validateNonEmpty(String tryCount) {
        if (tryCount.isEmpty()) {
            throw illegalArgumentException(NOTNULL_ERROR);
        }
    }

    private void validateNonNull(String tryCount) {
        if (Objects.isNull(tryCount)) {
            throw illegalArgumentException(NOTNULL_ERROR);
        }
    }

    private IllegalArgumentException illegalArgumentException(String errorMessage) {
        return RacingCarGameException.throwIllegalArgumentException(errorMessage);
    }
}

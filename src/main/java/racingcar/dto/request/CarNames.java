package racingcar.dto.request;

import java.util.Objects;
import racingcar.exception.RacingCarGameException;

public class CarNames {
    private static final String NULL_ERROR = "자동차 이름은 null이 될 수 없습니다.";
    private static final String EMPTY_ERROR = "자동차 이름을 최소 1글자 이상이어야 합니다.";

    private final String names;

    public CarNames(String names) {
        validate(names);
        this.names = names;
    }

    public static CarNames from(String names) {
        return new CarNames(names);
    }

    public String get() {
        return names;
    }

    private void validate(String names) {
        validateNonNull(names);
        validateNonEmpty(names);
    }

    private void validateNonEmpty(String names) {
        if (names.isEmpty()) {
            throw illegalArgumentException(EMPTY_ERROR);
        }
    }

    private void validateNonNull(String names) {
        if (Objects.isNull(names)) {
            throw illegalArgumentException(NULL_ERROR);
        }
    }

    private IllegalArgumentException illegalArgumentException(String errorMessage) {
        return RacingCarGameException.throwIllegalArgumentException(errorMessage);
    }
}

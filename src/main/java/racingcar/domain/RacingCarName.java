package racingcar.domain;

import org.junit.platform.commons.util.StringUtils;

import java.util.Objects;

public class RacingCarName {
    public static final String ERROR_MSG_OVER_LENGTH_LIMIT = "[ERROR] 자동차 이름은 5자 이하입니다.";
    public static final String ERROR_MSG_BLANK_OR_NULL = "[ERROR] 자동차 이름이 공백일 수 없습니다.";
    public static final int MAX_LENGTH_LIMIT_OF_RACING_CAR_NAME = 5;

    private final String racingCarNameValue;

    public RacingCarName(String racingCarName) {
        validName(racingCarName);
        this.racingCarNameValue = racingCarName;
    }

    private void validName(String racingCarName) {
        validBlankOrNull(racingCarName);
        validNameLength(racingCarName);
    }

    private void validBlankOrNull(String racingCarName) {
        if (racingCarName == null || StringUtils.isBlank(racingCarName)) {
            throw new IllegalArgumentException(ERROR_MSG_BLANK_OR_NULL);
        }
    }

    private void validNameLength(String racingCarName) {
        if (racingCarName.length() > MAX_LENGTH_LIMIT_OF_RACING_CAR_NAME) {
            throw new IllegalArgumentException(ERROR_MSG_OVER_LENGTH_LIMIT);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RacingCarName)) return false;
        RacingCarName that = (RacingCarName) o;
        return racingCarNameValue.equals(that.racingCarNameValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(racingCarNameValue);
    }

    public String getRacingCarNameValue() {
        return racingCarNameValue;
    }
}

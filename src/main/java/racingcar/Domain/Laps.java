package racingcar.Domain;

import org.junit.platform.commons.util.StringUtils;

public class Laps {
    private static final String WRONG_NUMBER_EMPTY = "입력값은 필수 입니다.";
    private static final String WRONG_NUMBER_TYPE = "숫자만 입력 가능 합니다.";
    public static final String REGEX = "[0-9]+";
    private final int lapNumber;

    public Laps(String lapNumber) {
        validationEmpty(lapNumber);
        validationNumberType(lapNumber);
        this.lapNumber = Integer.parseInt(lapNumber);
    }

    private void validationEmpty(String lapNumber) {
        if (StringUtils.isBlank(lapNumber)) {
            throw new IllegalArgumentException(WRONG_NUMBER_EMPTY);
        }
    }

    private void validationNumberType(String inputNumbers) {
        if (!inputNumbers.matches(REGEX)) {
            throw new IllegalArgumentException(WRONG_NUMBER_TYPE);
        }
    }

    public int getLapNumber() {
        return lapNumber;
    }
}

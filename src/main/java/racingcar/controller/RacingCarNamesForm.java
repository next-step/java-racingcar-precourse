package racingcar.controller;

import org.junit.platform.commons.util.StringUtils;

import java.util.regex.PatternSyntaxException;

public class RacingCarNamesForm {
    public static final String ERROR_MSG_BLANK_OR_NULL = "[ERROR] 자동차 이름이 공백일 수 없습니다.";
    public static final String ERROR_MSG_FORM = "[ERROR] 입력값이 잘못되었습니다. 자동차 이름은 쉼표(,)를 기준으로 구분합니다.";
    public static final String ERROR_MSG_OVER_LENGTH_LIMIT = "[ERROR] 자동차 이름은 5자 이하입니다.";
    public static final String ERROR_MSG_NUMBER_OF_NAMES = "[ERROR] 최소 2개 이상의 이름을 입력하세요.";
    public static final int MAX_LENGTH_LIMIT_OF_RACING_CAR_NAME = 5;
    public static final int MIN_NUMBER_OF_CAR_NAMES = 2;
    
    private final String[] racingCarNames;

    public RacingCarNamesForm(String racingCarNames) {
        this.racingCarNames = validateRacingCarNames(racingCarNames);
    }

    private String[] validateRacingCarNames(String racingCarNames) {
        validateBlankOrNull(racingCarNames);
        validateForm(racingCarNames);

        String[] racingCarNameArr = splitAndTrim(racingCarNames);

        validateNumberOfCarNames(racingCarNameArr);
        for (String carName : racingCarNameArr) {
            validateLength(carName);
            validateBlankOrNull(carName);
        }
        return racingCarNameArr;
    }

    private static String[] splitAndTrim(String racingCarNames) {
        String[] racingCarNameArr = racingCarNames.split(",");
        for (int i = 0; i < racingCarNameArr.length; i++) {
            racingCarNameArr[i] = racingCarNameArr[i].trim();
        }
        return racingCarNameArr;
    }

    private void validateBlankOrNull(String carName) {
        if (StringUtils.isBlank(carName) || carName == null) {
            throw new IllegalArgumentException(ERROR_MSG_BLANK_OR_NULL);
        }
    }

    private void validateForm(String racingCarNames) {
        try {
            racingCarNames.split(",");
        } catch (PatternSyntaxException exception) {
            throw new IllegalArgumentException(ERROR_MSG_FORM);
        }
    }

    private void validateNumberOfCarNames(String[] racingCarNameArr) {
        if (racingCarNameArr.length < MIN_NUMBER_OF_CAR_NAMES) {
            throw new IllegalStateException(ERROR_MSG_NUMBER_OF_NAMES);
        }
    }

    private void validateLength(String carName) {
        if (carName.length() > MAX_LENGTH_LIMIT_OF_RACING_CAR_NAME) {
            throw new IllegalArgumentException(ERROR_MSG_OVER_LENGTH_LIMIT);
        }
    }

    public String[] getRacingCarNames() {
        return racingCarNames;
    }
}

package com.ktc2.precourse.racingcar.exception;

import com.ktc2.precourse.racingcar.Config;

/**
 * 자동차 이름 길이가 지정된 값을 벗어나면 발생하는 예외
 */
public class InvalidCarNameLengthException extends GameException {

    private final static int nameMin = Config.CAR_NAME_MIN_LENGTH;
    private final static int nameMax = Config.CAR_NAME_MAX_LENGTH;

    public InvalidCarNameLengthException(String causeName) {
        super("\"" +causeName + "\": 이름은 " + nameMin + "자 이상 " + nameMax + "자 이하여야 합니다.");
    }
}

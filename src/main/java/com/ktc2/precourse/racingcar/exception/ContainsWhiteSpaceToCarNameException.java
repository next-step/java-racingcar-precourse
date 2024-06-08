package com.ktc2.precourse.racingcar.exception;

/**
 * 자동차 이름에 공백 문자가 포함되면 발생하는 예외
 */
public class ContainsWhiteSpaceToCarNameException extends GameException {

    public ContainsWhiteSpaceToCarNameException(String causeName) {
        super("\"" +causeName + "\": 이름에는 공백 문자가 포함될 수 없습니다.");
    }
}

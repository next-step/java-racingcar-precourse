package com.ktc2.precourse.racingcar.exception;

/**
 * 정수 형식이 아닐 경우 발생하는 예외
 */
public class NotIntegerException extends GameException {

    public NotIntegerException() {
        super("입력한 값이 정수 형식이 아닙니다.");
    }

}

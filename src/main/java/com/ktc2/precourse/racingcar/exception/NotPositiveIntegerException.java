package com.ktc2.precourse.racingcar.exception;

/**
 * 양의 정수가 아닐 경우 발생하는 예외
 */
public class NotPositiveIntegerException extends GameException {

    public NotPositiveIntegerException() {
        super("입력한 값이 양의 정수가 아닙니다.");
    }
}

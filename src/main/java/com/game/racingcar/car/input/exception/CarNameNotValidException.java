package com.game.racingcar.car.input.exception;

public class CarNameNotValidException extends IllegalArgumentException {
    private static final String NOT_VALID_EXCEPTION_MSG = "[오류] 유효하지 않은 자동차 이름입니다. 5글자 이내인지 확인 바랍니다.";

    public CarNameNotValidException() {
        super(NOT_VALID_EXCEPTION_MSG);
    }
}

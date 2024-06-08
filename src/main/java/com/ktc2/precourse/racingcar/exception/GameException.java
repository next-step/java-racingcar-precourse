package com.ktc2.precourse.racingcar.exception;

/**
 * 게임 중 발생하는 예외
 */
public class GameException extends RuntimeException {

    protected GameException(String message) {
        super("[Error] " + message + " 다시 입력해주세요.");
    }
}

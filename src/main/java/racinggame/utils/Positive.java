/*
 * Positive
 * java-racingcar-precourse
 *
 * Version 0.1
 *
 * Created by 강래민 on 2021-10-08.
 *
 * Copyright © 2021 raemerrr. All rights reserved.
 */
package racinggame.utils;

import racinggame.exception.IncorrectInputException;

public class Positive {

    private int value;

    /**
     * String 값을 넘겨받는 생성자
     *
     * @param value 전달받은 숫자 문자열
     */
    public Positive(String value) {
        int integer = Integer.parseInt(value);
        validatePositive(integer);
        this.value = integer;
    }

    /**
     * int 값을 넘겨받는 생성자
     *
     * @param value 전달받은 숫자
     */
    public Positive(int value) {
        validatePositive(value);
        this.value = value;
    }

    /**
     * value 값을 1 증가하는 로직
     */
    public void plus() {
        value++;
    }

    /**
     * @return 멤버변수 value 값을 반환
     */
    public int get() {
        return value;
    }

    /**
     * @param value 전달받은 숫자
     * @throws IncorrectInputException 입력한 수가 0 ~ 9 범위를 벗어난 경우 발생한다.
     */
    private void validatePositive(int value) {
        if (value < 0 || 9 < value) {
            throw new IncorrectInputException("0 ~ 9 범위를 벗어난 수를 입력할 수 없습니다.");
        }
    }
}

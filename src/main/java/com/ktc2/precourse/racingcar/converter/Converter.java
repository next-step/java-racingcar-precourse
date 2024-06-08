package com.ktc2.precourse.racingcar.converter;

import com.ktc2.precourse.racingcar.exception.GameException;

/**
 * T 타입 input이 유효한 경우 D로 변환하는 클래스
 *
 * @param <T> 변환하기 유효한 object 타입
 * @param <D> T가 유효할 경우 T의 변환된 타입
 */
public abstract class Converter<T, D> {

    /**
     * object를 유효성을 확인하고 D로 변환한다. input이 유효하지 않은 경우 예외가 발생한다.
     *
     * @param input D로 변환할 객체
     * @return 변환된 객체
     * @throws GameException input이 유효하지 않을 경우 발생하는 예외
     */
    public abstract D convertOrThrow(T input) throws GameException;

}

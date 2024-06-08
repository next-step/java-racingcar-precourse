package com.ktc2.precourse.racingcar.converter;

import com.ktc2.precourse.racingcar.exception.*;
import com.ktc2.precourse.racingcar.model.DtoAttemptsNumber;

/**
 * String을 양의 정수로 변환하는 Converter
 */
public class AttemptsNumberConverter extends Converter<String, DtoAttemptsNumber> {

    /**
     * String을 양의 정수로 변환함
     *
     * @param input 양의 정수로 변환할 String
     * @return 시도 횟수를 저장하고 있는 DTO
     * @throws NotIntegerException         String 형식이 정수가 아닌 경우
     * @throws NotPositiveIntegerException String 형식이 양의 정수가 아닌 경우
     */
    @Override
    public DtoAttemptsNumber convertOrThrow(String input) throws GameException {
        int num;

        //입력 문자열이 int로 변환될 수 있는 지 검사
        try {
            num = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NotIntegerException();
        }

        //양의 정수인 지 검사
        if (num <= 0) {
            throw new NotPositiveIntegerException();
        }

        //DTO를 반환한다.
        return new DtoAttemptsNumber(num);
    }
}

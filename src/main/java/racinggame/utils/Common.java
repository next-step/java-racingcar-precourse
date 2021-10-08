/*
 * Common
 * java-racingcar-precourse
 *
 * Version 0.2
 *
 * Created by 강래민 on 2021-10-08.
 *
 * Copyright © 2021 raemerrr. All rights reserved.
 */
package racinggame.utils;

import racinggame.constants.UtilsConstant;
import racinggame.exception.IncorrectInputException;

public final class Common {

    private Common() {

    }

    /**
     * @param value 전달받은 문자열
     * @return 문자열 비어있는지 여부
     */
    public static boolean isNullOrEmpty(String value) {
        if (value == null || value.isEmpty()) {
            return true;
        }
        return false;
    }

    /**
     * String 타입을 Integer 타입으로 변환할 수 있는지 검증
     *
     * @param input 입력받은 문자열
     */
    public static void validateStringToInteger(String input) {
        if (isNullOrEmpty(input) || !input.matches(UtilsConstant.ONLY_NUMBER_VALIDATE_REGEX)) {
            throw new IncorrectInputException("숫자가 아닌 문자열 또는 수식을 입력할 수 없습니다.");
        }
    }
}

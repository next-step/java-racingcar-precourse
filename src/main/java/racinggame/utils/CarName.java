/*
 * CarName
 * java-racingcar-precourse
 *
 * Version 0.3
 *
 * Created by 강래민 on 2021-10-08.
 *
 * Copyright © 2021 raemerrr. All rights reserved.
 */
package racinggame.utils;

import racinggame.constants.UtilsConstant;
import racinggame.exception.IncorrectInputException;

public class CarName {

    String name;

    /**
     * 생성자
     *
     * @param name 전달받은 문자열
     */
    public CarName(String name) {
        validateCarName(name);
        this.name = name;
    }

    /**
     * 자동차 이름 반환
     *
     * @return 멤버 변수 name 값
     */
    public String get() {
        return this.name;
    }

    /**
     * 입력 유효성 체크
     *
     * @param name 전달받은 문자열
     * @throws IncorrectInputException 제한된 범위를 벗어난 입력이 들어올 경우 발생한다.
     */
    private void validateCarName(String name) {
        if (Common.isNullOrEmpty(name) || UtilsConstant.MAX_CAR_NAME_LENGTH < name.length()) {
            throw new IncorrectInputException(String.format("%d 글자보다 긴 이름을 입력할 수 없습니다.", UtilsConstant.MAX_CAR_NAME_LENGTH));
        }
    }
}

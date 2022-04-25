package racingcar.utils;

import java.io.Serializable;

public enum ErrorMsgEnum {
    NAME_DUP_MSG("중복된 이름이 입력되었습니다."),
    NAME_TYPE_ERR_MSG("이름을 정확히 입력해주세요."),
    NO_NAME_MSG("입력된 이름이 없습니다."),
    OVER_MAX_LENGTH_MSG("이름이 5글자를 초과합니다."),
    REPEAT_COUNT_ERR_MSG("반복횟수를 잘못 입력하였습니다.");

    private final String value;

    ErrorMsgEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}

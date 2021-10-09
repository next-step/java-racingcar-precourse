package racinggame.common.enums;

import racinggame.common.Constant;

public enum Messages {
    CAR_NAME_INPUT("", "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    NUMBER_ATTEMPT("", "시도할 회수는 몇회인가요?"),
    PLAY_STATUS("", "실행 결과"),
    SIZE_CHECK(Constant.STR_ERROR, "자동차 이름은 5자라 이하로 입력해야 합니다.");

    private String code;
    private String detail;

    Messages(String code, String detail) {
        this.detail = detail;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return getMessage(Constant.STR_EMPTY);
    }

    public String getMessage(String code) {
        String str = Constant.STR_EMPTY;
        if (Constant.STR_EMPTY.equals(code)) str = detail;
        if (Constant.STR_ERROR.equals(code)) str = "[ERROR] " + detail;
        return str;
    }

}

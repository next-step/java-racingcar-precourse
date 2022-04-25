package racingcar.utils;

public enum ValidCommonConditionEnum {
    DELIMITER(","),
    REGEX_NUM("[0-9]+"),
    RESULT_MSG("실행결과"),
    RESULT_PREFIX(" : "),
    SCORE_VALUE("-"),
    WINNER_MSG("최종 우승자 : "),
    INPUT_CAR_NAME_MSG("경주할 자동차 이름 (이름은쉼표(,) 기준으로 구분)"),
    INPUT_REPEAT_CNT_MSG("시도할 횟수");

    private final String value;

    ValidCommonConditionEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}

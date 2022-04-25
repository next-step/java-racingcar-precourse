package racingcar.common;

public class Messages {
    public static final String START_MESSAGE = "경주할 자동차 이름을 입력하세요. (이름은 쉼표(,)기준으로 구분)";
    public static final String REPEAT_COUNT_SETTING = "경주 시도할 횟수";
    public static final String RACING_WINNER = "최종 우승자:";

    public static final String EXCEED_CAR_NAME_MAX_LENGTH = "[ERROR] 자동차 이름은 5자 이하만 가능합니다.";
    public static final String CAR_NAME_NOT_NULL = "[ERROR] 자동차 이름은 NULL로 설정할 수 없습니다.";
    public static final String CAR_NAME_NOT_EMPTY = "[ERROR] 자동차 이름은 필수로 지정해야합니다.";

    public static final String REPEAT_NOT_NUMBER = "[ERROR] 시도 횟수는 숫자만 입력 가능합니다.";
    public static final String REPEAT_NOT_ZERO = "[ERROR] 시도 횟수는 0보다 큰 값을 입력해야 합니다.";
}

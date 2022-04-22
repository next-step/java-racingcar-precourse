package racingcar.constant;

public class ExceptionMessage {
    public static final String CAR_NAME_IS_NOT_EMPTY = "[ERROR] 자동차 이름은 빈값일 수 없습니다.";
    public static final String CAR_NAME_IS_DONT_OVER_SIZE = String.format("[ERROR] 자동차 이름은 최대 %s자를 넘을 수 없습니다.",
            Conditions.NAME_MAX_SIZE);
    public static final String INVALID_INPUT_CAR_NAMES = "[ERROR] 자동차 이름으로 값이 입력되지 않았습니다.";
    public static final String INVALID_INPUT_RACING_GAME_STEP = "[ERROR] 시도할 횟수 값이 입력되지 않았습니다.";
    public static final String ONLY_NUMBER_INPUT_RACING_GAME_STPE = "[ERROR] 시도할 횟수 값은 오직 숫자만 가능합니다.";
}

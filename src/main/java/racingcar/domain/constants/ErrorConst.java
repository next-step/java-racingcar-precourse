package racingcar.domain.constants;

public class ErrorConst {
    public static final String CAR_NAMES_ERROR = "[ERROR] 자동차 이름은 5자 이하의 서로 다른 값이어야 합니다.";
    public static final String CAR_NAMES_EMPTY = "[ERROR] 빈 값을 입력할 수 없습니다.";
    public static final String CAR_NAMES_HAS_DUPLICATE = "[ERROR] 자동차 이름은 서로 다른 값이어야 합니다.";
    public static final String CAR_NAMES_INVALID_LENGTH = "[ERROR] 자동차 이름은 5자 이하의 값이어야 합니다.";
    public static final String TRY_NUMBER_ERROR = "[ERROR] 시도 횟수는 숫자여야 하며 1 이상이어야 합니다.";
    public static final String TRY_NUMBER_NOT_INTEGER = "[ERROR] 시도 횟수는 숫자여야 합니다.";
    public static final String TRY_NUMBER_SMALLER_THAN_ONE = "[ERROR] 시도 횟수는 1 이상의 숫자여야 합니다.";
    public static final String DISTANCE_OUT_OF_RANGE = "[ERROR] 랜덤숫자는 0-9 사이 값이어야 합니다.";
}

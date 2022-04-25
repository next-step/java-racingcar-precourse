package racingcar.common;

/**
 * ErrorMessage
 *
 * @author suji
 * @date 2022-04-23
 **/
public class ErrorMessage {
    public static String ERROR_PREFIX = "[ERROR]";

    public static String ERROR_CAR_NAME_EMPTY = formatErrorMessage("자동차 이름은 빈 값일 수 없습니다.");
    public static String ERROR_CAR_NAME_SIZE = formatErrorMessage("자동차 이름은 5자 이하만 가능합니다.");
    public static String ERROR_NOT_CARS = formatErrorMessage("경주 할 자동차가 생성되지 않았습니다.");
    public static String ERROR_NOT_MOVE_NUMBERS = formatErrorMessage("이동 조건 숫자가 생성되지 않았습니다.");
    public static String ERROR_MOVE_NUMBER_RANGE = formatErrorMessage("이동 조건 숫자는 0 에서 9 사이의 숫자만 가능합니다.");

    public static String ERROR_RACING_COUNT_EMPTY = formatErrorMessage("시도 횟수는 빈 값일 수 없습니다.");
    public static String ERROR_RACING_COUNT_RANGE = formatErrorMessage("시도 횟수는 1 이상의 숫자만 입력 가능합니다.");
    public static String ERROR_RACING_COUNT_MAX = formatErrorMessage("시도 가능한 최대 횟수는 2147483647 입니다.");

    private static String formatErrorMessage(String message) {
        return String.format("%s %s", ERROR_PREFIX, message);
    }
}

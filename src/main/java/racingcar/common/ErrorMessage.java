package racingcar.common;

public class ErrorMessage {
    public static final String ERROR_PREFIX = "[ERROR]";
    public static final String ERROR_CAR_NAME_EMPTY = formatErrorMessage("자동차 이름은 빈 값일 수 없습니다.");
    public static final String ERROR_CAR_NAME_OVER_SIZE = formatErrorMessage("자동차 이름은 5자 이하만 가능합니다.");
    public static final String ERROR_MOVE_NUMBER_RANGE = formatErrorMessage("전진 숫자는 0 에서 9 사이의 숫자만 가능합니다.");
    public static final String ERROR_PLAYING_COUNT_EMPTY = formatErrorMessage("이동 횟수는 빈 값일 수 없습니다.");
    public static final String ERROR_PLAYING_COUNT_RANGE = formatErrorMessage("이동 횟수는 양수만 입력 가능합니다.");
    public static final String ERROR_PLAYING_COUNT_MAX = formatErrorMessage("이동 횟수의 최댓값은 2147483647 입니다.");
    public static final String ERROR_NOT_CARS = formatErrorMessage("자동차가 생성되지 않았습니다.");

    private static String formatErrorMessage(String message) {
        return String.format("%s %s", ERROR_PREFIX, message);
    }
}

package racingcar.car.constant;

public class ErrorMessageConstant {
    private final static String ERROR_PREFIX = "[ERROR] %s";
    public final static String ERROR_COMMENT_CAR_NAME_LENGTH = String.format(ERROR_PREFIX, "차 이름은 1~5글자여야 합니다.");
    public final static String ERROR_COMMENT_CAR_NAME_COUNT = String.format(ERROR_PREFIX, "최소 한개 이상의 차 이름이 있어야 합니다.");
    public final static String ERROR_COMMENT_RACING_NUMBER_RANGE = String.format(ERROR_PREFIX, "시도 횟수는 양수여야 합니다.");
    public final static String ERROR_COMMENT_RACING_NUMBER_PARSE = String.format(ERROR_PREFIX, "시도 횟수는 숫자여야 합니다.");

}

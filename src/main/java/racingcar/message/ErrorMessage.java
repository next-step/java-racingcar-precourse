package racingcar.message;

public class ErrorMessage {
    private static final String ERROR_PREFIX = "[ERROR]";
    public static final String ROUND_RANGE_ERROR = String.format("%s 시도할 횟수에는 1~9만 입력할 수 있습니다.", ERROR_PREFIX);
    public static final String CAR_NAME_LENGTH_ERROR = String.format("%s 자동차 이름은 1~5글자만 입력할 수 있습니다.", ERROR_PREFIX);
    public static final String CAR_NAME_FORMAT_ERROR = String.format("%s 자동차 이름은 알파벳과 숫자만 입력할 수 있습니다.", ERROR_PREFIX);
    public static final String CAR_NAME_DUPLICATED_ERROR = String.format("%s 자동차 이름은 중복일 수 없습니다.", ERROR_PREFIX);
}

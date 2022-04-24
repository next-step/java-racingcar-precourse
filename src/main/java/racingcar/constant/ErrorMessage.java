package racingcar.constant;

public class ErrorMessage {

    private static final String ERROR_HEAD = "[ERROR] ";

    public static final String CAR_NAME_LIMIT = ERROR_HEAD + "자동차 이름은 길이 1~5 사이로 입력해주세요.";
    public static final String CAR_NAME_DUPLICATION = ERROR_HEAD + "자동차 이름은 중복을 허용하지 않습니다.";
    public static final String CAR_NAME_NUMBER_OF_TWO = ERROR_HEAD + "자동차 이름은 2개 이상으로 입력해주세요.";
    public static final String CAR_NAME_LAST_COMMA = ERROR_HEAD + "쉼표(,)로 끝날 수 없습니다.";
    public static final String ROUND_NOT_POSITIVE_NUMBER = ERROR_HEAD + "시도 횟수는 1이상의 숫자여야 합니다.";
    public static final String ROUND_NOT_RANGE = ERROR_HEAD + "시도 횟수가 너무 많습니다.";

    private ErrorMessage() {
        throw new IllegalStateException("Constant class");
    }
}

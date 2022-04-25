package racingcar;

public class ErrorMessage {

    private static final String ERROR_MESSAGE_PREFIX = "[ERROR]";

    public static final String RACING_CAR_NAME_LENGTH_ERROR = ERROR_MESSAGE_PREFIX + "자동차 이름을 5글자 이내로 입력해주세요.";

    public static final String RACING_CAR_NAME_SPLITER_ERROR = ERROR_MESSAGE_PREFIX + "구분자가 없습니다.";

    public static final String RACING_CAR_NUMBER_ERROR = ERROR_MESSAGE_PREFIX + "0 ~ 9 사이의 숫자를 입력해주세요.";

    public static final String COMMAND_COUNT_ERROR = ERROR_MESSAGE_PREFIX + "명령 횟수를 숫자로 입력하세요.";

}

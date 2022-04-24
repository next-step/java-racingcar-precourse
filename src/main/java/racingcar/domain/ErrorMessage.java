package racingcar.domain;

public class ErrorMessage {

    public static final String ERROR_MESSAGE_PREFIX = "[ERROR]";
    public static final String CAR_NAME_DELIMITER_ERROR_MESSAGE = ERROR_MESSAGE_PREFIX + "자동차 이름 구분자는 쉼표(,)입니다.";
    public static final String CAR_NAME_LENGTH_ERROR = ERROR_MESSAGE_PREFIX + "자동차 이름은 5자 이하만 가능합니다.";

    public static final String GAME_ROUND_INPUT_ERROR = ERROR_MESSAGE_PREFIX + "1이상의 숫자만 입력해주세요.";

}

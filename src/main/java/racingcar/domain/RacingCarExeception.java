package racingcar.domain;

public class RacingCarExeception {
    private static final String default_message = "[ERROR] ";
    public static final String DUPLICATION_ARGUMENTS_ERROR = default_message + "입력된 명칭이 중복되었습니다.";
    public static final String LACK_NUMBER_OF_CARS_ERROR = default_message + "입력된 자동차의 숫자가 부족합니다";
    public static final String UNKNOWN_PARSE_NAMES_ERROR = default_message+"파싱 중 알 수 없는 에러가 발생하였습니다.";
    public static final String EXCEED_LENGTH_OF_NAME_ERROR = default_message+"자동차 이름의 길이는 5이하여야 합니다.";
    public static final String INPUT_WRONG_NUMBER_ERROR = default_message+"잘못된 숫자를 입력하였습니다.";
    public static final String INPUT_WRONG_RANGE_ERROR = default_message+"잘못된 범위의 숫자를 입력하였습니다. 숫자는 0보다 커야 합니다.";
}

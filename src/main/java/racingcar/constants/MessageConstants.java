package racingcar.constants;

public class MessageConstants {
    public static final String ERROR_MESSAGE_BASE = "[ERROR] %s";
    public static final String ERROR_MESSAGE_NAME_NULL_EMPTY = "이름 값이 null 이거나 비어있습니다.";
    public static final String ERROR_MESSAGE_NAME_OVER_LIMIT = "이름은 %d 자 이하여야 합니다.";
    public static final String ERROR_MESSAGE_CAR_LIST_NULL_EMPTY = "차량 리스트가 null 이거나 비어있습니다.";
    public static final String ERROR_MESSAGE_CAR_NAMES_INPUT_EMPTY = "차량 이름들의 입력값이 비었습니다.";
    public static final String ERROR_MESSAGE_ATTEMPTS_NUMBER_INPUT_EMPTY = "시도 횟수의 입력값이 비었습니다.";
    public static final String ERROR_MESSAGE_ATTEMPTS_NUMBER_NOT_NUMERIC = "시도 횟수의 입력값이 숫자가 아닙니다.";
    public static final String ERROR_MESSAGE_ATTEMPTS_NUMBER_NOT_POSITIVE = "시도 횟수의 입력값이 양수가 아닙니다.";

    public static final String CONSOLE_MESSAGE_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String CONSOLE_MESSAGE_ATTEMPTS_NUMBER = "시도할 회수는 몇회인가요?";
    public static final String CONSOLE_MESSAGE_RACE_RESULT = "실행 결과";
    public static final String CONSOLE_MESSAGE_RACE_WINNER = "최종 우승자: ";

    public static final String SEPARATOR_CAR_POSITION = " : ";
    public static final String SEPARATOR_WINNER = ", ";
    public static final String SIGN_CAR_POSITION = "-";
}

package racingcar.utils;

public class Constants {
    public static final Integer CAR_NAME_MAX_LENGTH = 5;
    public static final Integer DEFAULT_CAR_POSITION = 0;
    public static final Integer RANDOM_MIN_NUMBER = 0;
    public static final Integer RANDOM_MAX_NUMBER = 9;
    public static final Integer CAR_MOVING_CONDITION = 4;
    public static final Integer CAR_MOVING_AMOUNT = 1;

    public static final String ERROR_PREFIX = "[ERROR] ";
    public static final String ERROR_ILLEGAL_CAR_NAME = "자동차 이름은 빈 값 일 수 없고, 5자를 초과할 수 없습니다.";
    public static final String ERROR_ILLEGAL_ACCESS = "해당 위치의 자동차가 없습니다.";
    public static final String ERROR_ILLEGAL_NUMBER_INPUT = "숫자만 입력해야 합니다.";
    public static final String ERROR_ILLEGAL_RANGE_NUMBER_INPUT = "1 이상의 숫자를 입력해야 합니다.";

    public static final String MESSAGE_CAR_NAME_INPUT = "경주할 자동차 이름을 입력하세요.";
    public static final String MESSAGE_CAR_NAME_CONDITION = "(이름은 쉼표(,) 기준으로 구분)";
    public static final String MESSAGE_GAME_REPEAT_COUNT = "시도할 회수는 몇회인가요?";
    public static final String MESSAGE_CAR_INFO_PRINT = "%s : %s\n";
    public static final String MESSAGE_FINAL_WINNER = "최종 우승자 : ";

    public static final String DIV = ", ";
}

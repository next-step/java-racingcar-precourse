package racingcar.model;

public class Message {
    public static final String SPLIT = ",";
    public static final String SPLIT_NAME = "쉼표";
    public static final String CAR_POSITION_CHAR = "-";
    public static final String NAME_AND_POS_SEPARATOR = " : ";

    public static final String ERROR = "[ERROR]";
    public static final String ERROR_NAME_LEN_OVER = "이름의 길이는 최대 "+Rule.CAR_NAME_MAX_LEN+"글자 입니다";
    public static final String ERROR_NAME_USE_NOT_SPACE = "이름에는 공백이 올 수 없습니다";
    public static final String ERROR_LAPS_ONLY_DIGIT = "시도 횟수는 숫자만 올 수 있습니다";
    public static final String ERROR_LAPS_NOT_NEGATIVE = "시도 횟수는 0보다 큰 숫자여야 합니다";

    public static final String CAR_NAME_INPUT = "경주 할 자동차 이름(이름은 "+SPLIT_NAME+"("+SPLIT+") 기준으로 구분)";
    public static final String RACING_LAPS_INPUT = "시도할 회수는 몇회인가요?";
    public static final String RACING_RESULT_MSG = "실행 결과";
    public static final String RACING_WINNER_MSG = "최종 우승자: ";
}

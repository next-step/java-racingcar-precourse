package racingcar.util;

public class Payload {
    private static String PREFIX = "[ERROR] ";
    public static String ERROR_NAME_LENGTH = PREFIX + "이름은 5글자보다 작아야 합니다. 입력된 길이: ";
    public static String ERROR_TRY_NUMBER_TYPE = PREFIX + "시도 횟수는 숫자여야 한다.";
    public static String EXECUTION_RESULT = "\n실행 결과";
    public static String EMPTY = "";
    public static String SEPARATOR = ",";
    public static String NOTICE_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static String NOTICE_TRY_NUMBER = "시도할 회수";
    public static String SPLIT_REGEXP = "\\s*,\\s*";
    public static String FINAL_WINNER = "최종 우승자 : ";
    public static String COLON = " : ";
    public static String TRACK_SHAPE = "-";
}

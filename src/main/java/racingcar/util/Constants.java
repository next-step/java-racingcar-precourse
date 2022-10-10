package racingcar.util;

public class Constants {
    public static String MSG_GET_ENTRY = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static String MSG_GET_ROUND = "시도할 회수는 몇회인가요?";
    public static String MSG_WINNER = "최종 우승자";
    
    public static String COMMA = ",";
    public static String RESULT = "실행 결과";
    public static String COLON = ":";
    public static String HYPHEN = "-";
    public static String WHITESPACE = " ";
    public static String NEWLINE = "\n";
    public static int ZERO = 0;
    public static int TWO = 2;
    
    public static String ERR_1_TO_5_CHAR = "[ERROR] 자동차 이름은 1자에서 5자 사이로 입력해 주세요.";
    public static String ERR_OVER_2_CARS = "[ERROR] 최소 2개의 자동차 이름을 입력해 주세요.";
    public static String ERR_NOT_NUMBER = "[ERROR] 시도 회수는 숫자여야 합니다.";
    public static String ERR_NOT_ZERO = "[ERROR] 시도 회수는 0이 될 수 없습니다.";
    
    public static String REGEX_1_TO_5_CHAR = "^.{1,5}$";
    public static String REGEX_NOT_NUMBER = "^[0-9]+$";
    public static String REGEX_NOT_ZERO = "^[0]+$";
    
}

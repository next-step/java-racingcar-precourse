package racingcar.config;

public class Message {
    public static String ERROR_NAME_LENGTH_WRONG    = "이름의 길이가 잘못되었습니다.";
    public static String ERROR_COUNT_WRONG          = "잘못된 값을 입력하셨습니다.(정수 입력)";
    public static String ERROR_INPUT_CAR_NAME       = "경주할 자동차를 1대 이상 입력해 주세요.";
    public static String ERROR_INVALID_RANGE        = "랜덤 값의 범위를 벗어났습니다.";
    public static String ERROR_ENGINE_NULL          = "Engine을 설정해주세요.";
    public static String ERROR_VALIDATOR_NULL       = "이름 검증 validator를 설정해주세요.";
    public static String ERROR_CAR_FACTORY_NULL     = "Car factory가 설정되어야 합니다.";
    public static String ERROR_RACING_CAR_GAME_NULL = "Racing car Game이 설정되어야 합니다.";
    public static String ERROR_CARS_NULL            = "Cars가 설정되어야 합니다.";
    public static String ERROR_INVALID_CNT          = "실행할 횟수를 0 이상 입력해주세요.";

    public static String GUIDE_INPUT_CAR_NAME       = "경주할 자동차 이름을 입력하세요.(이름은쉼표(,) 기준으로 구분)";
    public static String GUIDE_INPUT_COUNT          = "시도할 회수는 몇 회인가요?";

    public static String FORMAT_SPLIT               = ",";
    public static String FORMAT_WINNER_PRINT        = "최종 우승자: %s%n";
    public static String FORMAT_WINNER_EACH         = ", ";
    public static String FORMAT_CAR_PRINT           = "%s : %s";
    public static String FORMAT_ERROR_PRINT         = "[ERROR] %s%n";
}

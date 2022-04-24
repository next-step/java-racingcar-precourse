package racingcar.ui;

public class Output {
    public static final String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String INPUT_RACING_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";

    private static final String ERROR_prefix = "[ERROR] ";
    public static final String ERROR_NOT_ALLOW_EMPTY_CAR_NAMES_MESSAGE = "빈값은 입력할 수 없습니다.";
    public static final String ERROR_ONLY_ABLE_TO_INPUT_AS_NUMBER_MESSAGE = "숫자만 입력할 수 있습니다.";

    public static void printInputCartNameMessage() {
        System.out.println(INPUT_CAR_NAME_MESSAGE);
    }
    public static void printInputRacingCountMessage() {
        System.out.println(INPUT_RACING_COUNT_MESSAGE);
    }
    public static void printErrorMessage(String error) { System.out.println(ERROR_prefix + error); }
}

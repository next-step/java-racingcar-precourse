package racingcar.view;

public class Message {

    private static final String ERROR = "[ERROR] ";
    private static final String INPUT_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String NAME_CAN_NOT_BE_MORE_THEN_5_DIGITS = ERROR + "이름은 5자 이하만 가능 합니다.";
    private static final String GAME_COUNT_MUST_BE_DIGITS = ERROR + "시도 횟수는 숫자여야 합니다.";
    private static final String INPUT_GAME_COUNT = "시도할 횟수는 몇회인가요?";

    public static String getNameCanNotBeMoreThen5Digits() {
        return NAME_CAN_NOT_BE_MORE_THEN_5_DIGITS;
    }

    public static String getGameCountMustBeDigits() {
        return GAME_COUNT_MUST_BE_DIGITS;
    }

    public static String getInputCarNames() {
        return INPUT_CAR_NAMES;
    }

    public static String getInputGameCount() {
        return INPUT_GAME_COUNT;
    }
}

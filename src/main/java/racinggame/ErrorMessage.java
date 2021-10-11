package racinggame;

public class ErrorMessage {
    private static final String ERROR_TITLE = "[ERROR]";
    private static final String NOT_NULL_NAME_MESSAGE = " 차 이름을 입력 해 주세요.";
    private static final String NOT_CORRECT_NAME_LENGTH_MESSAGE = " 차 이름이 5자 이상입니다.";

    private static final String NOT_POSITIVE_MOVE_COUNT_MESSAGE = " 차 이동 횟수는 0보다 커야 합니다.";

    private static final String NOT_NUMBER_GAME_END_POINT = " 입력한 시도 횟수가 숫자가 아닙니다. ";

    private ErrorMessage() {

    }

    public static String printNotNullNameMessage() {
        return String.format(ERROR_TITLE + NOT_NULL_NAME_MESSAGE);
    }

    public static String printNotCorrectNameLengthMessage(String name) {
        return String.format(ERROR_TITLE + NOT_CORRECT_NAME_LENGTH_MESSAGE + " : %s", name);
    }

    public static String printNotPositiveMoveCountMessage(int moveCount) {
        return String.format(ERROR_TITLE + NOT_POSITIVE_MOVE_COUNT_MESSAGE);
    }

    public static String printNotNumberGameEndPointMessage(String gameEndCount) {
        return String.format(ERROR_TITLE + NOT_NUMBER_GAME_END_POINT + " : %s", gameEndCount);
    }
}

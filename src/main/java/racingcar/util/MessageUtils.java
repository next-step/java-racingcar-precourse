package racingcar.util;

public class MessageUtils {
    static final String ERROR_LABEL = "[ERROR]";
    public static final String INPUT_CAR_NAME_MESSAGE =
            "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String INPUT_ERROR_NUMBER_MESSAGE =
            ERROR_LABEL + " 입력값은 숫자여야만 합니다.";
    public static final String INPUT_TRY_RACE = "시도할 회수는 몇회인가요?";

    public static final String OUT_LAST_WINNER = "최종 우승자:";



    public static String getErrorMessage(String exceptionMessage) {
        return ERROR_LABEL + " " + exceptionMessage;
    }
}

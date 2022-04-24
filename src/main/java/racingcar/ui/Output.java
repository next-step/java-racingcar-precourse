package racingcar.ui;

import java.util.ArrayList;

public class Output {
    private static final String REQUEST_CAR_NAME_LIST_INPUT_MESSAGE = "경주 할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String REQUEST_NUMBER_OF_RUN_INPUT_MESSAGE = "시도할 횟수는 몇회인가요?";
    private static final String RESULT_MESSAGE = "\n실행결과";
    private static final String RESULT_OUTPUT_MESSAGE = " : ";
    private static final String RESULT_WINNER_MESSAGE = "최종우승자 : ";
    private static final String EXCEPTION_MESSAGE = "\n[ERROR]";
    public static final String NAME_LENGTH_EXCEPTION_MESSAGE = "이름은 5자 이하만 가능합니다.\n";
    public static final String NAME_DUPLICATE_EXCEPTION_MESSAGE = "중복된 이름이 존재합니다.\n";
    public static final String ATTEMPT_FORMAT_EXCEPTION_MESSAGE = "시도할 횟수는 숫자만 입력 가능합니다.\n";

    public static void printCarNameListInput() {
        System.out.println(REQUEST_CAR_NAME_LIST_INPUT_MESSAGE);
    }

    public static void printAttemptInput() {
        System.out.println(REQUEST_NUMBER_OF_RUN_INPUT_MESSAGE);
    }

    public static void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public static void printResultOutputMessage(String carName, String progress) {
        System.out.println(carName + RESULT_OUTPUT_MESSAGE + progress);
    }

    public static void printResultWinnerMessage(ArrayList<String> winnerList) {
        System.out.print(RESULT_WINNER_MESSAGE + winnerList.get(0));
        for (int i = 1; i < winnerList.size(); i++) {
            System.out.print(", " + winnerList.get(i));
        }
        System.out.println();
    }

    public static void printExceptionMessage(String exceptionMessage) {
        System.out.println(EXCEPTION_MESSAGE + exceptionMessage);
    }

    public static void printEmptyLine() {
        System.out.println();
    }
}

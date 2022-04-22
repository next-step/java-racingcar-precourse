package racingcar.common;

public class PrintMessage {
    public static final String INPUT_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String INPUT_NUMBER_MESSAGE = "시도할 회수는 몇회인가요?";
    public static final String RESULT_HEADER_MESSAGE = "실행 결과";

    public static void printInputNamesMessage() {
        System.out.println(INPUT_NAMES_MESSAGE);
    }

    public static void printInputNumberMessage() {
        System.out.println(INPUT_NUMBER_MESSAGE);
    }

    public static void print(String message) {
        System.out.println(message);
    }

    public static void printLine() {
        System.out.println();
    }

    public static void printResultHeaderMessage() {
        System.out.println();
        System.out.println(RESULT_HEADER_MESSAGE);
    }
}

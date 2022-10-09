package racingcar.view;

public class OutputResult {
    private static final String OUTPUT_LAP_RESULT = "실행 결과";
    private static final String OUTPUT_CHAMPION = "최종 우승자 : ";

    public static void printResultMessage() {
        printNewLineMessage(OUTPUT_LAP_RESULT);
    }

    public static void printCarForwardState(String carName, int forwardState) {
        printMessage(carName + " : ");
        for (int i = 0; i < forwardState; i++) {
            printMessage("-");
        }
        printNewLineMessage("");
    }

    public static void printChampion(String champion) {
        printMessage(OUTPUT_CHAMPION + champion);
    }

    public static void printMessage(String message) {
        System.out.print(message);
    }

    public static void printNewLineMessage(String message) {
        System.out.println(message);
    }
}

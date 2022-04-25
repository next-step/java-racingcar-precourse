package racingcar.ui;

import racingcar.model.Cars;

public class ResultView {
    private static final String RESULT_TITLE_MESSAGE = "실행 결과";
    private static final String WINNER_TITLE_MESSAGE = "최종 우승자: ";
    private static final String ERROR_TITLE = "[ERROR] ";

    public static void printResultMessage() {
        System.out.println(RESULT_TITLE_MESSAGE);
    }

    public static void printCarsPosition(String status) {
        System.out.println(status);
    }

    public static void printWinnerCars(Cars winnerCars) {
        System.out.println(WINNER_TITLE_MESSAGE + String.join(", ", winnerCars.getCarNames()));
    }

    public static void printError(String msg) {
        System.out.println(ERROR_TITLE + msg);
    }
}

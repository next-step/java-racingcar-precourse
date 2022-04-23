package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import static java.lang.System.out;

public final class GameView {

    private static final String ENTER_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분";
    private static final String ENTER_TRY_NUMBER = "시도할 회수는 몇회인가요?";
    private static final String FINAL_CHAMPIONSHIP = "최종 우승자: ";
    private static final String START_MESSAGE = "실행 결과";

    private GameView() {
        throw new ClassCastException();
    }

    public static String enterMessage() {
        return Console.readLine();
    }

    public static void printEnterCarNames() {
        out.println(ENTER_CAR_NAMES);
    }

    public static void printEnterTryNumber() {
        out.println(ENTER_TRY_NUMBER);
    }

    public static void printFinalResultMessage(String carNames) {
        out.println(FINAL_CHAMPIONSHIP + carNames);
    }

    public static void println() {
        out.println();
    }

    public static void printMessage(String message) {
        out.println(message);
    }

    public static void printStartMessage() {
        out.println(START_MESSAGE);
    }

}

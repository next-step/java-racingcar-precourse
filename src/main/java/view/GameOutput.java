package view;

import java.util.List;

public class GameOutput {

    private static final String ENTER_CAR_NAME = "경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)";
    private static final String ENTER_AGAIN = " 다시 입력해 주세요.";
    private static final String ATTEMPT_COUNT = "시도할 횟수는 몇 회인가요?";
    private static final String ATTEMPT_COUNT_ENTER_POSITIVE = "시도 횟수는 1 이상의 숫자로 입력해 주세요.";
    private static final String GAME_RESULT_COMMENT = "실행 결과";
    private static final String GAME_RESULT = "가 최종 우승했습니다.";
    private static final String COMMA = ",";

    public static void printEnterCarNames() {
        System.out.println(ENTER_CAR_NAME);
    }

    public static void printEnterAgain(Exception e) {
        System.out.println(e.getMessage() + ENTER_AGAIN);
    }

    public static void printAttemptCount() {
        System.out.println(ATTEMPT_COUNT);
    }

    public static void printReEnterAttemptCount() {
        System.out.println(ATTEMPT_COUNT_ENTER_POSITIVE);
    }

    public static void printGameResultComment() {
        System.out.println(GAME_RESULT_COMMENT);
    }

    public static void printTravelDistanceForCar(String name, int distance) {
        System.out.print(name + " : ");
        for (int i = 0; i < distance; i++)
            System.out.print("-");
        System.out.println();
    }

    public static void crlf() {
        System.out.println();
    }

    public static void printWinners(List<String> winners) {
        winners.forEach(winner -> {
            System.out.print(winner);
            printComma(winners, winner);
        });
        System.out.println(GAME_RESULT);
    }

    private static void printComma(List<String> winners, String winner) {
        if (isNotLastWinner(winners, winner))
            System.out.print(COMMA);
    }

    private static boolean isNotLastWinner(List<String> winners, String winner) {
        return winners.indexOf(winner) != winners.size() - 1;
    }
}

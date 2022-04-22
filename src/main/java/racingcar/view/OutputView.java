package racingcar.view;

public final class OutputView {
    public static void printGameStart() {
        System.out.println("실행 결과");
    }

    public static void printEmptyLine() {
        System.out.println();
    }

    public static void printGameRoundResult(String roundResult) {
        System.out.println(roundResult);
    }

    public static void printGameWinner(String winner) {
        System.out.println("최종 우승자: " + winner);
    }

    public static void printError(String errorMessage) {
        System.out.println(errorMessage);
    }

}

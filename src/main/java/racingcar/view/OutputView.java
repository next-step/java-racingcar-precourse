package racingcar.view;

public class OutputView {
    public static void showResult(String winnerNames) {
        final String message = String.format("최종 우승자: %s", winnerNames);
        System.out.println(message);
    }

}

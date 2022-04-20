package racingcar.view;

import racingcar.domain.Name;

public class OutputView {
    public static void showResult(String winnerNames) {
        final String message = String.format("최종 우승자는 %s 입니다.", winnerNames);
        System.out.println(message);
    }

    public static void progressView() {
    }
}

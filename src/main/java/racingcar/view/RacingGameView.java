package racingcar.view;


import racingcar.model.Car;
import racingcar.model.Cars;

import java.util.List;

public final class RacingGameView {

    private RacingGameView() {}

    public static void printRequestCarNames() {
        System.out.println("경주 할 자동차 이름(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void printRequestExecutionCount() {
        System.out.println("시도할 횟수");
    }

    public static void printError(String message) {
        System.out.println(message);
    }

    public static void printExecutionResultInitialMessage() {
        System.out.println("\n실행 결과");
    }

    public static void printExecutionResult(Cars cars) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Car car : cars.get()) {
            stringBuilder.append(car.getName().get())
                    .append(" : ");
            appendBar(stringBuilder, car);
            stringBuilder.append("\n");
        }
        System.out.println(stringBuilder);
    }

    public static void printWinners(List<String> winners) {
        String result = String.join(", ", winners);
        System.out.println("최종 우승자 : " + result);
    }

    private static void appendBar(StringBuilder stringBuilder, Car car) {
        int position = car.getPosition().get();
        for (int i = 0; i < position; i++) {
            stringBuilder.append("-");
        }
    }
}

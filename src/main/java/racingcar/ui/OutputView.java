package racingcar.ui;

import java.util.List;
import java.util.StringJoiner;
import racingcar.domain.Car;

public class OutputView {
    private static final String ERROR_MESSAGE = "[ERROR]";
    private static final String ROAD = "-";
    private static final String WINNERS_JOINER = ", ";

    private OutputView() {
    }

    public static void printGameResult() {
        System.out.println("실행 결과");
    }

    public static void printResultPerRace(List<Car> cars) {
        for (Car car : cars) {
            System.out.printf("%s : %s\n", car.getName(), locationToRoad(car.getLocation()));
        }
        System.out.println();
    }

    private static String locationToRoad(final int location) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < location; i++) {
            stringBuilder.append(ROAD);
        }
        return stringBuilder.toString();
    }

    public static void printWinners(List<Car> winners) {
        System.out.printf("최종 우승자 : %s", conCatWinners(winners));
    }

    private static String conCatWinners(List<Car> winners) {
        StringJoiner stringJoiner = new StringJoiner(WINNERS_JOINER);
        for (Car winner : winners) {
            stringJoiner.add(winner.getName());
        }
        return stringJoiner.toString();
    }

    public static void printIllegalArgumentException(IllegalArgumentException e) {
        System.out.printf("%s%s\n", ERROR_MESSAGE, e.getMessage());
    }
}

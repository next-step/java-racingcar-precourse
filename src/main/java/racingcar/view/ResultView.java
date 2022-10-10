package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.List;

public class ResultView {
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String PROGRESS_BAR = "-";
    private static final String COMMA = ", ";

    public static void printResultStart() {
        System.out.println(RESULT_MESSAGE);
    }

    public static void printResult(List<Cars> racingSheets) {
        for (Cars cars : racingSheets) {
            printRound(cars);
        }
    }

    private static void printRound(Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.println(car.getName() + " : " + makeProgress(car.getMoveDistance()));
        }
        System.out.println();
    }

    private static String makeProgress(int moveDistance) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < moveDistance; i++) {
            stringBuilder.append(PROGRESS_BAR);
        }
        return String.valueOf(stringBuilder);
    }

    public static void printWinner(List<Car> winners) {
        String winner = "";
        for (int i = 0; i < winners.size(); i++) {
            winner += winners.get(i).getName();
            winner = addComma(winners, winner, i);
        }

        System.out.println("최종 우승자 : " + winner);
    }

    private static String addComma(List<Car> winners, String winner, int i) {
        if (i < winners.size() - 1) {
            winner += COMMA;
        }
        return winner;
    }
}

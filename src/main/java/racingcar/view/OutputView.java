package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.RacingGame;
import racingcar.domain.RacingGameHistory;

public class OutputView {
    public static final String DASH = "-";
    public static final String RACING_RESULT = "실행 결과";
    public static final String RACING_CAR_INFO = "%s : %s\n";
    public static final String WINNER = "최종 우승자: %s";

    public static void printRacingResult(RacingGame racingGame) {
        System.out.println(RACING_RESULT);
        printRacingHistory(racingGame.getHistory());
        printRacingWinner(racingGame.getResult().getWinnerCars());
    }

    public static void printRacingHistory(RacingGameHistory history) {
        for (Cars cars : history.getCarsList())
            printCarsInfo(cars);
    }

    public static void printCarsInfo(Cars cars) {
        for (Car car : cars.getCarItems())
            System.out.printf(RACING_CAR_INFO, car.getCarName().getName(), getCarMoveDash(car.getDistance()));
        System.out.println();
    }

    public static String getCarMoveDash(int distance) {
        StringBuilder stringBuilder = new StringBuilder();
        while (distance-- > 0)
            stringBuilder.append(DASH);

        return stringBuilder.toString();
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }

    private static void printRacingWinner(Cars winnerCars) {
        System.out.printf(WINNER, Cars.getWinnerNames(winnerCars.getWinnerCars()));
    }
}

package racingcar.view;

import racingcar.constant.CarStatus;
import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.List;

public class Output {
    private static final String RACE_RESULT_STRING = "실행결과";
    private static final String WINNER_STRING = "최종 우승자 : ";
    private static final String GO_FORWARD_STRING = "-";
    private static final String COMMA_JOIN_STRING = ", ";

    public static void showRaceResult(int tryRound, Cars cars) {
        System.out.println(RACE_RESULT_STRING);

        for (int i = 0; i < tryRound; i++) {
            showRaceRoundResult(i, cars);
            Common.printEmptyLine();
        }
    }

    private static void showRaceRoundResult(int currentRound, Cars cars) {
        for (Car car : cars.getCars()) {
            printCarName(car.getName());
            printDistances(currentRound, car.getDistances());
            Common.printEmptyLine();
        }
    }

    private static void printCarName(String carName) {
        System.out.print(carName + " : ");
    }

    private static void printDistances(int currentCount, List<Boolean> distances) {
        for (int i = 0; i <= currentCount; i++) {
            printDistance(i, distances);
        }
    }

    private static void printDistance(int round, List<Boolean> distances) {
        if (distances.get(round) == CarStatus.MOVE) {
            System.out.print(GO_FORWARD_STRING);
        }
    }

    public static void printRaceWinner(List<String> winners) {
        System.out.println(WINNER_STRING + String.join(COMMA_JOIN_STRING, winners));
    }
}

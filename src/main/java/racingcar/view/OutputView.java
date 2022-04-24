package racingcar.view;

import java.util.List;

import racingcar.common.GameConfig;
import racingcar.common.Message;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class OutputView {
    public static void printInputErrorMessage(IllegalArgumentException e) {
        System.out.println(e);
    }

    public static void printRoundResult() {
        System.out.println("\n" + Message.ROUND_RESULT);
    }

    public static void printRaceRound(Cars cars) {
        List<Car> carList = cars.getCars();
        carList.forEach(car -> System.out.println(car.getName().getName() + " : " + printMoveDistance(car)));
        System.out.println();
    }

    private static String printMoveDistance(Car car) {
        StringBuilder sb = new StringBuilder();
        for (int index = 0; index < car.getPosition().getPosition(); index++) {
            sb.append(GameConfig.MOVE_DISPLAY);
        }
        return sb.toString();
    }

    public static void printFinalWinner(List<Car> winnerList) {
        System.out.print(Message.FINAL_WINNER_PREFIX);
        winnerList.forEach(car -> System.out.print(addSeperator(winnerList.indexOf(car)) + car.getName().getName()));
    }

    private static String addSeperator(int index) {
        return index > 0 ? GameConfig.CAR_NAME_SEPERATOR + " " : "";
    }
}

package racinggame.view;

import racinggame.common.Const;
import racinggame.controller.RaceController;
import racinggame.domain.Car;

import java.util.List;

public class OutputView {

    public static void printCarsPosition(List<Car> cars) {
        for(Car car : cars) {
            System.out.println(RaceController.getResultLane(car));
        }
        System.out.print('\n');
    }

    public static void printWinners(List<Car> cars) {
        List<String> winnerNames = RaceController.getWinnerNames(cars);
        System.out.println(RaceController.getWinnersLane(winnerNames) + Const.IS_WINNER);
    }
}

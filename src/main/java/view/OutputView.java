package view;

import controller.RaceController;
import domain.Car;
import message.Message;

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
        System.out.println(RaceController.getWinnersLane(winnerNames) + Message.IS_WINNER);
    }

}

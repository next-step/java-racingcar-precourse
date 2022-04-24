package racingcar.view;

import racingcar.model.Car;
import racingcar.model.GameResult;

import java.util.List;

public class ResultView {

    public static void printRound(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car);
        }
        System.out.println();
    }

    public static void printWinner(GameResult result) {
        System.out.println("최종 우승자:" + result.getWinnerName());
    }
}

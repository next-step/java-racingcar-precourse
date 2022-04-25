package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.RacingCarGame;

import java.util.ArrayList;
import java.util.List;

public class ResultView {
    public static void showResult(RacingCarGame game) {
        for (Car car : game.getCars()) {
            showCarName(car);
            showLocation(car);
        }
        System.out.printf("\n");
    }

    private static void showCarName(Car car) {
        System.out.printf(car.getName() + " : ");
    }

    private static void showLocation(Car car) {
        for (int i = 0; i < car.getLocation() + 1; i++) {
            System.out.printf("-");
        }
        System.out.printf("\n");

    }

    public static void showWinners(RacingCarGame game) {
        List<Car> winners = game.findWinners();

        List<String> winnerNames = new ArrayList<>();
        for (Car winner : winners) {
            winnerNames.add(winner.getName());
        }

        System.out.println("최종 우승자: " + String.join(", ", winnerNames));
    }
}

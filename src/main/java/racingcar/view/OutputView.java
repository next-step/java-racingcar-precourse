package racingcar.view;

import racingcar.controller.RaceResult;
import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class OutputView {

    private OutputView() {
    }

    public static void printProgress(RaceResult raceResult) {
        for (Car car : raceResult.getPlayers()) {
            System.out.print(car.getName() + " : ");
            System.out.println(getProgress(car));
            System.out.println();
        }
        System.out.println();
    }

    private static String getProgress(Car car) {
        StringBuilder progress = new StringBuilder();
        for (int i = 0; i < car.getPosition(); i++) {
            progress.append("-");
        }
        return progress.toString();
    }

    public static void printWinners(RaceResult raceResult) {
        List<String> winnerNames = new ArrayList<>();
        for (Car winner : raceResult.getWinners()) {
            winnerNames.add(winner.getName());
        }
        System.out.println("최종 우승자: " + String.join(",", winnerNames));
    }


}

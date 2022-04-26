package racingcar.view;

import racingcar.RacingCar;
import racingcar.RacingCarName;
import racingcar.RacingCars;

import java.util.List;
import java.util.StringJoiner;

public class PrintView {
    public static void printErrorMessage(String message) {
        System.out.println("[ERROR] " + message);
    }

    public static void printWinnerNames(List<RacingCarName> winnerNames) {
        StringJoiner stringJoiner = new StringJoiner(",");
        for (RacingCarName name : winnerNames) {
            stringJoiner.add(name.getValue());
        }
        System.out.println("최종 우승자는 " + stringJoiner + " 입니다.");
    }

    public static void printGameResult(RacingCars racingCars) {
        for (RacingCar racingCar : racingCars.getRacingCars()) {
            System.out.println(racingCar.getRacingCarName().getValue() + " : " + racingCar.getLocation());
        }

        printBlankLine();
    }

    private static void printBlankLine() {
        System.out.println();
    }

}

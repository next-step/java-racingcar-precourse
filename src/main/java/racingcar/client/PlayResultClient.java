package racingcar.client;

import org.assertj.core.util.Strings;
import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.List;

public class PlayResultClient {
    private static final String DELIMITER_FOR_WINNER_CAR_NAMES = ", ";
    private static final String MESSAGE_FORMAT_FOR_WINNER_CAR = "최종 우승자 : %s%n";

    private PlayResultClient() {
    }

    public static void printWinnerCarNames(List<String> winnerCarNames) {
        String winnerCarNamesString = Strings.join(winnerCarNames).with(DELIMITER_FOR_WINNER_CAR_NAMES);

        System.out.printf(MESSAGE_FORMAT_FOR_WINNER_CAR, winnerCarNamesString);
    }

    public static void printCurrentCarPositions(Cars cars) {
        for (Car car : cars.getCarList()) {
            System.out.println(car.getCarName() + " : " + getCarPositionGraphic(car.getPosition()));
        }

        System.out.println();
    }

    private static String getCarPositionGraphic(int position) {
        StringBuilder graphic = new StringBuilder("");

        for (int i = 0; i < position; i++) {
            graphic.append("-");
        }

        return graphic.toString();
    }
}

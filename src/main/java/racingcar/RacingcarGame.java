package racingcar;

import racingcar.domain.Cars;
import racingcar.ui.RacingcarIO;

import static racingcar.domain.rule.RacingcarGameRule.SEPERATOR;

public class RacingcarGame {

    private static Cars cars;

    public static void main(String[] args) {
        start();
    }

    public static void start() {
        askCarNames(RacingcarIO.requestCarNames());
    }

    private static void askCarNames(String carNames) {
        try {
            cars = new Cars(carNames.split(SEPERATOR));
        } catch (Exception e) {
            RacingcarIO.printlnMessage(e.getMessage());
            askCarNames(RacingcarIO.requestCarNames());
        }
    }

}

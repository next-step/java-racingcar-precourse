package racingcar;

import racingcar.domain.Cars;
import racingcar.domain.Round;
import racingcar.ui.RacingcarIO;

import static racingcar.domain.rule.RacingcarGameRule.SEPERATOR;

public class RacingcarGame {

    private static Cars cars;
    private static Round round;

    public static void main(String[] args) {
        start();
    }

    public static void start() {
        askCarNames(RacingcarIO.requestCarNames());
        askRound(RacingcarIO.requestRound());
    }

    private static void askRound(String inputRound) {
        try {
            round = new Round(inputRound);
        } catch (Exception e) {
            RacingcarIO.printlnMessage(e.getMessage());
            askRound(RacingcarIO.requestRound());
        }
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

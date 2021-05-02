package racingcar;

import racingcar.domain.RacingCarGame;
import racingcar.ui.RacingCarIO;

public class RacingCarMain {

    private static RacingCarGame racingcarGame;

    public static void main(String[] args) {
        start();
    }

    public static void start() {
        generateRacingCarGame(askCarNames(), askRound());
    }

    private static void generateRacingCarGame(String carNames, String round) {
        try {
            racingcarGame = new RacingCarGame(carNames, round);
        } catch (Exception e) {
            printErrorMessage(e);
            generateRacingCarGame(askCarNames(), askRound());
        }
    }

    private static String askCarNames() {
        return RacingCarIO.requestCarNames();
    }

    private static String askRound() {
        return RacingCarIO.requestRound();
    }

    private static void printErrorMessage(Exception e) {
        RacingCarIO.printlnMessage(e.getMessage());
    }

}

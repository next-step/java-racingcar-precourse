package racingcar;

import racingcar.controller.RacingGame;

import static racingcar.view.OutputView.printErrorMessage;


public class Application {
    private static final int ERROR_STEP_DEFAULT = 0;
    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame(ERROR_STEP_DEFAULT);
        while(true) {
            try {
                racingGame.ready();
                racingGame.start();
            } catch (IllegalArgumentException e) {
                printErrorMessage(e.getMessage());
                racingGame.createErrorPoint(e.getMessage());
                continue;
            }
            break;
        }

    }
}

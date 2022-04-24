package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.RacingGame;
import racingcar.domain.RacingReport;
import racingcar.view.GameView;

public class GameController {

    private static final String CAR_NAME_DELIMITER = ",";
    private final GameView gameView;

    public GameController(GameView gameView) {
        this.gameView = gameView;
    }

    public void start() {
        try {
            String[] carNames = waitingForCarNames();
            RacingGame racingGame = new RacingGame(carNames);
            int numOfTrial = waitingForNumOfTrials();
            RacingReport finalReport = play(racingGame, numOfTrial);
            gameView.printFinal(finalReport);
        } catch (IllegalArgumentException ex) {
            gameView.printError(ex.getMessage());
        }
    }

    private String[] waitingForCarNames() {
        gameView.carNamesEnterMessage();
        String userInput = Console.readLine();
        return userInput.split(CAR_NAME_DELIMITER);
    }

    private int waitingForNumOfTrials() {
        gameView.numOfTrialMessage();
        String userInput = Console.readLine();
        try {
            return Integer.parseInt(userInput);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 한다.");
        }
    }

    private RacingReport play(RacingGame racingGame, int numOfTrial) {
        RacingReport report = new RacingReport();
        gameView.playMessage();

        for (int i = 0; i < numOfTrial; i++) {
            report = racingGame.race();
            gameView.printReport(report);
        }

        return report;
    }
}

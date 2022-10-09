package racingcar.controller;


import java.util.List;
import racingcar.model.RetryCount;
import racingcar.model.ScoreBoard;
import racingcar.view.Input;
import racingcar.view.Output;

/**
 * @author: Minwoo Kim
 * @date 2022/10/09
 */
public class RacingCarGame {

    private final ScoreBoard scoreBoard = new ScoreBoard();
    private final RetryCount retryCount = new RetryCount();

    private void createCars() {
        List<String> carNames = Input.getCarNamesUntilValid();
        scoreBoard.addNewRacingCars(carNames);
    }

    private void setRetryCount() {
        int retryValue = Input.getRetryCountUntilValid();
        retryCount.setValue(retryValue);
    }

    private void proceedMoving() {
        Output.initiativePrintStatus();
        int retryValue = retryCount.getValue();
        for (int i = 0; i < retryValue; i++) {
            scoreBoard.moveAllCars();
            Output.printStatus(scoreBoard);
        }
    }

    private void getWinners() {
        Output.gameResultAnnounce(scoreBoard);
    }

    public void start() {
        createCars();
        setRetryCount();
        proceedMoving();
        getWinners();
    }
}

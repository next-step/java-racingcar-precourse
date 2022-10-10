package racingcar.controller;

import racingcar.model.*;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

    /* 게임에서 사용될 5자 이하로 구성된 자동차 배열이 구성될때까지 재귀 */
    public Cars prepareCars() {
        try {
            return new Cars(InputView.inputCarNames());
        } catch (IllegalArgumentException | IllegalStateException e){
            OutputView.printErrorMessage(e.getMessage());
        }

        return prepareCars();
    }

    /* 게임에서 사용될 1이상의 시도횟수 값을 받을때까지 재귀 */
    public Progress prepareProgressCount() {
        try {
            int count = InputView.inputProgressCount();
            return new Progress(count);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
        }
        return prepareProgressCount();
    }

    public void play(Cars cars, Progress progress) {
        Game game = new Game(cars, progress);

        GameResults gameResults = game.play();
        game.end();
        Cars winners = gameResults.lastGameResult().winners();

        printResult(gameResults, winners);
    }

    public void printResult(GameResults gameResults, Cars winners) {
        OutputView.printBlank();
        OutputView.printResultGuide();

        totalProgressResult(gameResults);

        OutputView.printWinners(winners.totalCarNames());
    }

    private void totalProgressResult(GameResults gameResults) {
        for (int i = 0; i < gameResults.size(); i++) {
            numberOfTryResult(gameResults.getGameResult(i));
        }
    }

    public void numberOfTryResult(GameResult gameResult) {
        for (int i = 0; i < gameResult.size(); i++) {
            OutputView.printPlayerMove(gameResult.geResult().getCar(i));
        }

        OutputView.printBlank();
    }
}
package racingcar.controller;

import racingcar.model.RacingCar;
import racingcar.model.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingGameController {

    private RacingGame racingGame = new RacingGame();
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();



    public void start() {
        readyCar();
        initGameCount();
        startGame();
        showPlayResult();
        showWinners();
    }

    private void readyCar() {
        String carName = inputView.getCarNames();
        try {
            racingGame.ready(carName);
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            readyCar();
        }
    }

    private void initGameCount() {
        String round = inputView.getRound();
        try {
            racingGame.initRound(round);
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            initGameCount();
        }

    }

    private void startGame() {
        racingGame.play();
    }

    private void showPlayResult() {
        List<RacingCar> racingCarList = racingGame.getPlayResult();
        List<RacingCarResultDto> racingCarResultDtos = new ArrayList<>(racingCarList.size());
        for (RacingCar racingCar : racingCarList) {
            racingCarResultDtos.add(RacingCarResultDto.from(racingCar));
        }

        outputView.showPlayResult(racingCarResultDtos, racingGame.getRound());
    }

    private void showWinners() {
        outputView.showWinners(this.racingGame.getWinners());
    }
}

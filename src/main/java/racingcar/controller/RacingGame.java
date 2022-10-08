package racingcar.controller;

import racingcar.model.RacingCarNames;
import racingcar.model.RacingCars;
import racingcar.model.Round;
import racingcar.service.GameManager;
import racingcar.service.RoundManager;
import racingcar.util.Message;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGame {

    private final RacingCars racingCars;
    private Round round;
    private RoundManager roundManager;
    private GameManager gameManager;

    public RacingGame() {
        this.racingCars = new RacingCars();
    }

    public void play() {
        init();
        roundManager.playRound();
        OutputView.print(Message.RESULT.getMessage());
        gameManager.calculateResult();
        gameManager.printResult();
    }

    private void init() {
        inputRacingCarName();
        inputRound();

        this.roundManager = new RoundManager(round, racingCars);
        this.gameManager = new GameManager(racingCars);
    }

    private void inputRacingCarName() {
        try {
            RacingCarNames racingCarNames = new RacingCarNames(InputView.getCarNames());
            racingCars.add(racingCarNames.getNames());
        }catch (IllegalArgumentException e) {
            OutputView.print(e.getMessage());
            inputRacingCarName();
        }
    }

    private void inputRound() {
        try {
            this.round = new Round(InputView.getRound());
        }catch (IllegalArgumentException e) {
            OutputView.print(e.getMessage());
            inputRound();
        }
    }
}

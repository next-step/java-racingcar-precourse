package racingcar.controller;

import racingcar.model.Racer;
import racingcar.view.Output;

import java.util.stream.IntStream;

public class GameController {

    // TODO: 경기시작, 재시작, 종료
    private Racer racers;
    private int numberOfRaces;

    public GameController() {
        createGame();
        startGame();
        finishGame();
    }

    public void createGame() {
        racers = new Racer(InputController.setRacers());
        numberOfRaces = InputController.setNumberOfRound();
    }

    public void startGame() {
        Output.printResultMessage();
        IntStream.range(0, numberOfRaces).forEach(index -> racers.raceCars());
    }

    public void finishGame() {
        racers.pickWinner();
    }
}

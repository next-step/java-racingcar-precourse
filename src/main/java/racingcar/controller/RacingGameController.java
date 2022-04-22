package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Name;
import racingcar.domain.RacingGame;
import racingcar.domain.RacingGameStep;
import racingcar.domain.Winners;
import racingcar.domain.engine.Engine;
import racingcar.generator.NumberGenerator;
import racingcar.view.PlayPrinter;
import racingcar.view.PlayerInput;

public class RacingGameController {

    private final PlayerInput playerInput;
    private final PlayPrinter playPrinter;
    private final NumberGenerator numberGenerator;


    public RacingGameController(PlayerInput playerInput, PlayPrinter playPrinter, NumberGenerator numberGenerator) {
        this.playerInput = playerInput;
        this.playPrinter = playPrinter;
        this.numberGenerator = numberGenerator;
    }

    public void execute() {
        List<Name> names = this.playerInput.inputNames();
        Cars cars = Cars.of(names, Engine.createBy(numberGenerator));
        RacingGameStep racingGameStep = this.playerInput.inputRacingGameStep();
        RacingGame racingGame = RacingGame.of(cars, racingGameStep);

        playGame(racingGame);
        printWinners(racingGame);
    }

    private void printWinners(RacingGame racingGame) {
        List<Car> winnerCars = racingGame.findMaxDistanceCars();
        Winners winners = Winners.from(winnerCars);

        playPrinter.printWinners(winners.getNames());
    }

    private void playGame(RacingGame racingGame) {
        int playStep = 0;
        while (!racingGame.isEndGame(playStep)) {
            racingGame.play();
            playPrinter.playPrint(racingGame.getCars());
            playStep++;
        }
    }
}

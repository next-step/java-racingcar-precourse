package racingcar.game;

import racingcar.car.Cars;
import racingcar.game.round.Round;
import racingcar.game.round.Turn;

public class Game {

    private final RaceCars raceCars;

    private Game() {
        this.raceCars = RaceCars.of(
                Cars.init(), Round.fromConsole());
    }

    public static Game init() {
        return new Game();
    }

    public void run() {
        Printer.runGame();

        while (!raceCars.finishAny()) {
            progress();
        }

        Printer.winners(raceCars.winners());
    }

    private void progress() {
        for (RaceCar car : raceCars.cars()) {
            car.go(Turn.progress());
        }

        Printer.emptyLine();
    }

}

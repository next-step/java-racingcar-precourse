package racinggame.model;

import racinggame.controller.IOController;
import racinggame.vo.GameTurnCnt;

public class RacingGame {
    private IOController ioController;

    public RacingGame(IOController ioController){
        this.ioController = ioController;
    }

    public Cars play(Cars cars, GameTurnCnt turnCnt) {
        this.ioController.startShowingGameResult();

        this.runTurns(cars, turnCnt);

        Cars winnerCars = cars.findFurthestCars();

        return winnerCars;
    }

    private void runTurns(Cars cars, GameTurnCnt turnCnt) {
        for (int i = 0; i < turnCnt.get(); i++) {
            this.runOneTurn(cars);

            this.ioController.writeContent(cars.toString());
        }
    }

    private void runOneTurn(Cars cars) {
        for (Car car : cars) {
            CarMover.moveRandomizly(car);
        }
    }
}

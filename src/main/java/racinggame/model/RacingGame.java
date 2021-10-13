package racinggame.model;

import racinggame.controller.IOController;
import racinggame.enums.RANDOM_MOVE_RESULT;
import racinggame.vo.Car;
import racinggame.vo.Cars;
import racinggame.vo.GameTurnCnt;

public class RacingGame {
    private IOController ioController;
    private WinnerPicker winnerPicker;

    public RacingGame(IOController ioController) {
        this.ioController = ioController;

        this.winnerPicker = new WinnerPicker();
    }

    public Cars play(Cars cars, GameTurnCnt turnCnt) {
        this.ioController.startShowingGameResult();

        this.runTurns(cars, turnCnt);

        return this.winnerPicker.getWinnerCars();
    }

    private void runTurns(Cars cars, GameTurnCnt turnCnt) {
        this.winnerPicker.standBy(cars);

        for (int i = 0; i < turnCnt.get(); i++) {
            this.runOneTurn(cars);

            this.ioController.writeContent(cars.toString());
        }
    }

    private void runOneTurn(Cars cars) {
        for (Car car : cars) {
            RANDOM_MOVE_RESULT moveResult = CarMover.moveRandomizly(car);

            this.winnerPicker.tryPick(car, moveResult);
        }
    }
}

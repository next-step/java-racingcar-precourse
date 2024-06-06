package view;

import controller.Validation;
import controller.GameController;

public class Game {

    private GameController gameController = new GameController();

    public void start() {
        carNamesProgress();
    }

    public void carNamesProgress() {
        Output.printCarNamesProgress();
        while (true) {
            String[] carNames = Input.scanCarNames();
            try {
                Validation.checkCarNames(carNames);
                this.gameController.setCars(carNames);
                break;
            } catch (IllegalArgumentException e) {
                Output.printException();
            }
        }
    }
}

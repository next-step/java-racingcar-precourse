package view;

import controller.Validation;
import controller.GameController;

public class Game {

    private GameController gameController = new GameController();
    private int number;

    public void start() {
        carNamesProcess();

        numberProcess();

        Output.printResultProgress();
        for(int i=0; i<number; i++) {
            Output.printResult(this.gameController.addCarsDistance());
        }
    }

    public void carNamesProcess() {
        Output.printCarNamesProgress();
        while (true) {
            String[] carNames = Input.scanCarNames();
            try {
                this.gameController.setCars(carNames);
                break;
            } catch (IllegalArgumentException e) {
                Output.printException();
            }
        }
    }

    public void numberProcess() {
        Output.printNumberProgress();
        while (true) {
            String strNumber = Input.scanNumber();
            try {
                Validation.checkNumber(strNumber);
                this.number = Integer.parseInt(strNumber);
                break;
            } catch (IllegalArgumentException e) {
                Output.printException();
            }
        }
    }
}

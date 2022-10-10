package racingcar;

import racingcar.controller.GameController;
import racingcar.model.Cars;
import racingcar.model.Progress;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController();

        OutputView.printCarNamesInputGuide();
        Cars cars = gameController.prepareCars();

        OutputView.printNumberOfTryInputGuide();
        Progress progress = gameController.prepareProgressCount();

        gameController.play(cars, progress);
    }
}
package racingcar.controller;

import racingcar.model.CarNameSplit;
import racingcar.model.GameRule;
import racingcar.model.TryCount;
import racingcar.model.car.Cars;
import racingcar.view.GameResultView;
import racingcar.view.UserInputView;

public class RacingCarController {

    private UserInputView userInputView = new UserInputView();
    private GameResultView gameResultView = new GameResultView();

    public RacingCarController() {
    }

    public void startRacingGame() {
        Cars cars = new Cars(generateCar());
        GameRule gameRule = new GameRule(generateCount());
        cars.runGame(gameRule);
        cars.getWinner();
        gameResultView.ResultMessage(cars, gameRule);

    }

    private Cars generateCar() {
        try {
            return new Cars(new CarNameSplit(userInputView.inputCarNameMessage()));
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            return generateCar();
        }
    }

    private TryCount generateCount() {
        try {
            return new TryCount(userInputView.inputCountMessage());
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            return generateCount();
        }
    }

}

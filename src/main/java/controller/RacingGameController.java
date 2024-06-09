package controller;

import domain.RacingCars;
import util.CreatingCar;
import view.InputView;
import view.OutputView;

public class RacingGameController {
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    public void startGame(){
        RacingCars racingCar = createRacingCar();
    }
    private RacingCars createRacingCar(){
        outputView.printRequestCarNames();
        String[] carNames = inputView.inputCarNames();
        return CreatingCar.createCars(carNames);
    }
}

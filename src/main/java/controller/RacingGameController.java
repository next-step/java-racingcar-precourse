package controller;

import domain.RacingCars;
import domain.TryialNum;
import util.CreatingCar;
import util.RandomGeneratingMove;
import view.InputView;
import view.OutputView;

public class RacingGameController {
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private final RandomGeneratingMove randomGeneratingMove = new RandomGeneratingMove();
    public void startGame(){
        RacingCars racingCars = createRacingCars();
        TryialNum tryialNum = getTryCount();

        racing(racingCars, tryialNum);
    }

    private RacingCars createRacingCars(){
        outputView.printRequestCarNames();
        String[] carNames = inputView.inputCarNames();
        return CreatingCar.createCars(carNames);
    }

    private TryialNum getTryCount(){
        outputView.printRequestTryCount();
        String inputTryCount = inputView.inputTryCount();
        return new TryialNum(inputTryCount);
    }

    private void racing(RacingCars cars, TryialNum tryialNum) {
        outputView.printExecutionResult();

        for (int i = 0; i < tryialNum.getTrialNum(); i++) {
            cars.moveAll(randomGeneratingMove);
            outputView.printRoundByExecutionResults(cars);
        }
        outputView.printRacingCarWinnerResult(cars);
    }

}

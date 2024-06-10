package controller;

import domain.RacingCars;
import domain.TrialNum;
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
        TrialNum trialNum = getTryCount();

        racing(racingCars, trialNum);
    }

    private RacingCars createRacingCars(){
        outputView.printRequestCarNames();
        String[] carNames = inputView.inputCarNames();
        return CreatingCar.createCars(carNames);
    }

    private TrialNum getTryCount(){
        outputView.printRequestTryCount();
        String inputTryCount = inputView.inputTryCount();
        return new TrialNum(inputTryCount);
    }

    private void racing(RacingCars cars, TrialNum trialNum) {
        outputView.printExecutionResult();

        for (int i = 0; i < trialNum.getTrialNum(); i++) {
            cars.moveAll(randomGeneratingMove);
            outputView.printRoundByExecutionResults(cars);
        }
        outputView.printRacingCarWinnerResult(cars);
    }

}

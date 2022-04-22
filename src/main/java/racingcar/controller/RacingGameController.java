package racingcar.controller;

import racingcar.model.RacingCars;
import racingcar.util.StringUtil;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingGameController {

    public void racingStart(){
        RacingCars racingCars = new RacingCars();

        setRacingCars(racingCars);

        int tryNumber = setTryNumber();
        ResultView.getPrintMessage("");

        ResultView.getResultTitleMessage();
        for (int i = 0; i < tryNumber; i++) {
            playing(racingCars);
        }

        racingCars.findWinnerCars();
        ResultView.getResultFinalWinnerMessage(racingCars.getWinners());

    }

    private void setRacingCars(RacingCars racingCars) {
        try {
            racingCars.registerCars(StringUtil.splitStringToList(InputView.inputCarsName()));
        } catch (IllegalArgumentException e) {
            ResultView.getPrintMessage(e.getMessage());
            setRacingCars(racingCars);
        }
    }

    private int setTryNumber() {
        int tryNumber = 0;

        try {
            tryNumber = InputView.inputTryNumber();
        } catch (IllegalArgumentException e) {
            ResultView.getPrintMessage(e.getMessage());
            setTryNumber();
        }

        return tryNumber;
    }

    private void playing(RacingCars racingCars){
        racingCars.compete();
        ResultView.getPrintMessage("");
    }
}

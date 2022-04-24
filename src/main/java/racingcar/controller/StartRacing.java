package racingcar.controller;

import racingcar.model.RacingResult;
import racingcar.view.InputMessageView;

public class StartRacing {

    public StartRacing() {
        RacingResult racingResult = setRacing();
        racingResult.racing();
        racingResult.getResult();
    }

    public RacingResult setRacing(){
        String carNames = InputMessageView.inputRacingCarName();
        String tryCount = InputMessageView.inputTryCount();
        try{
            return new RacingResult(carNames, tryCount);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return setRacing();
        }
    }
}

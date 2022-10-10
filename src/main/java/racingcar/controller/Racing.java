package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.TryCount;
import racingcar.view.View;

public class Racing {
    private final View view = new View();

    public void start(){
        Cars cars = new Cars(view.inputCarNameView());
        TryCount tryCount = new TryCount(view.inputTryCountView());
        view.outputResultView();
        for(int i = 0; i < tryCount.getCount(); i++){
            cars.goOrStop();
        }
        cars.getWinner();
    }
}

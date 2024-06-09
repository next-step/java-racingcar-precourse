package main.java.racingcar;

import main.java.racingcar.domain.Cars;
import main.java.racingcar.message.ViewMessage;
import main.java.racingcar.view.InputView;

public class MainController {

    public void run() {
        Cars cars = this.initCars();
    }

    private Cars initCars() {
        String inputValue = InputView.inputString(ViewMessage.INPUT_CAR_NAME);
        return Cars.createByString(inputValue);
    }


}

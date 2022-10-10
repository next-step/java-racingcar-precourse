package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.service.CarService;
import racingcar.view.ErrorView;
import racingcar.view.RacingResultView;
import racingcar.view.UserCarView;
import racingcar.view.UserTryNumberView;

public class CarController {

    CarService carService = new CarService();

    public Cars getCars() {
        try {
            UserCarView userCarView = new UserCarView();
            userCarView.print();
            return carService.getCars(userCarView.read());
        } catch(IllegalArgumentException iae) {
            handleError(iae.getMessage());
            return getCars();
        }
    }

    public int getTryNumber() {
        try {
            UserTryNumberView userTryNumberView = new UserTryNumberView();
            userTryNumberView.print();
            return carService.getTryNumber(userTryNumberView.read());
        } catch(IllegalArgumentException iae) {
            handleError(iae.getMessage());
            return getTryNumber();
        }
    }

    public void play(Cars cars, int tryNumber) {
        RacingResultView racingResultView = new RacingResultView();
        racingResultView.print(carService.race(cars, tryNumber));
    }

    public void handleError(String message) {
        ErrorView errorView = new ErrorView();
        errorView.print(message);
    }
}

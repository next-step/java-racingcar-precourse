package racingcar.controller;

import racingcar.model.CarName;
import racingcar.model.RacingCar;
import racingcar.view.InputView;

public class InputController {
    public static RacingCar setRacingCars(){
        try{
            CarName validatedNames = new CarName(InputView.carInput());
            return new RacingCar(validatedNames.names_arr);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return setRacingCars();
        }
    }

}

package racingcar.controller;

import racingcar.model.RacingCarGameValidator;
import racingcar.model.RacingCars;
import racingcar.view.RacingGameInputReader;

public class RacingCarGame {
    private RacingCars racingCars;
    private RacingCarGameValidator racingCarGameValidator;

    public  RacingCarGame() {
        this.racingCars = new RacingCars();
        this.racingCarGameValidator = new RacingCarGameValidator();
    }

    public void start() {
        while (!racingCarGameValidator.isValid()) {
            racingCarGameValidator.racingCarNamesValidate(RacingGameInputReader.inquireRacingCarNames());
        }


//        for (String carName : RacingGameInputReader.inquireRacingCarNames().split(",")) {
//            racingCars.addRacingCar(carName);
//        }

//        System.out.println("racingCars = " + racingCars);
    }



}

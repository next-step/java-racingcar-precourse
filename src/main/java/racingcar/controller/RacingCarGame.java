package racingcar.controller;

import racingcar.model.RacingCarGameValidator;
import racingcar.model.RacingCars;
import racingcar.view.RacingCarGameInputReader;

public class RacingCarGame {
    private RacingCars racingCars;
    private RacingCarGameValidator racingCarGameValidator;

    public  RacingCarGame() {
        this.racingCars = new RacingCars();
        this.racingCarGameValidator = new RacingCarGameValidator();
    }

    public void start() {
        while (!racingCarGameValidator.isValid()) {
            racingCarGameValidator.racingCarNamesValidate(RacingCarGameInputReader.inquireRacingCarNames());
        }
        racingCarGameValidator.initValidator();
        while (!racingCarGameValidator.isValid()) {
            racingCarGameValidator.racingCarGameRoundsValidate(RacingCarGameInputReader.inquireRacingCarGameRounds());
        }


//        for (String carName : RacingCarGameInputReader.inquireRacingCarNames().split(",")) {
//            racingCars.addRacingCar(carName);
//        }

//        System.out.println("racingCars = " + racingCars);
    }



}

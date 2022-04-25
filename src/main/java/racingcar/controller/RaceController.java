package racingcar.controller;

import racingcar.dto.Cars;
import racingcar.service.RaceService;

public class RaceController {
    public static final String INPUT_MESSAGE_FOR_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    public void play() {
        System.out.println(INPUT_MESSAGE_FOR_CAR_NAME);
        Cars cars = new Cars();

        RaceService raceService = new RaceService();
        raceService.setupCars(cars);
        raceService.raceCars(cars);
    }
}

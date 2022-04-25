package racingcar.controller;

import racingcar.service.RacingCarService;

public class RacingCarController {

    private static RacingCarService racingCarService = new RacingCarService();

    public void run() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉽표(,) 기준으로 구분)");
        racingCarService.inputRacingCar();

        System.out.println("시도할 횟수");
        racingCarService.racingCarsPlay();
    }
}

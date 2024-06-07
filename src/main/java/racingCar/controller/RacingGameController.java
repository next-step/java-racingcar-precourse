package racingCar.controller;

import racingCar.CarConfig;
import racingCar.service.CarService;
import racingCar.view.InputView;
import racingCar.view.OutputView;

public class RacingGameController {
    private final CarService carService;

    /**
     * CarConfig로 부터 CarService 객체를 가져와 의존성 주입
     */
    public RacingGameController() {
        carService = CarConfig.getCarService();                 // DI
    }

    /**
     * 경주의 전반적인 프로세스를 진행하는 메서드
     */
    public void race() {
        String carNames = InputView.inputCarName();             // user input
        int tryNum = InputView.inputTryNum();                   // user input
        carService.saveCars(carNames);                          // Generate Car instances and save to repository
        raceStart(tryNum);                                      // start racing game
        OutputView.printFinalWinner(carService.getWinner());    // print winner
    }

    /**
     * 입력된 횟수 만큼 반복하며 레이스의 각 라운드를 진행하는 메서드
     * @param tryNum 반복 라운드 횟수
     */
    private void raceStart(int tryNum) {
        for(int round = 0; round < tryNum; round++) {
            carService.playRound();                                 // play round
            OutputView.printGameResult(carService.getAllCars());    // print round result
        }
    }
}

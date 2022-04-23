package racingcar.service;

import racingcar.domain.RacingCarList;
import racingcar.domain.WinnerRacingCarList;

import java.util.List;

public class RacingCarFacade {

    private final CarMessengerService carMessengerService;
    private final RacingCarService racingCarService;

    public RacingCarFacade(CarMessengerService carMessengerService, RacingCarService racingCarService) {
        this.carMessengerService = carMessengerService;
        this.racingCarService = racingCarService;
    }

    public void racingStart() {
        List<String> carList = carMessengerService.inputCarList();
        int moveNum = carMessengerService.inputMoveNum();
        RacingCarList racingCar = racingCarService.createRacingCar(carList);
        for (int i = 0; i < moveNum; i++) {
            racingCarService.racingCarMove(racingCar);
            carMessengerService.printRacingCarStatus(racingCar);
        }
        int maxPosition = racingCarService.racingCarMaxPosition(racingCar);
        WinnerRacingCarList winnerList = racingCarService.racingCarWinner(racingCar, maxPosition);
        carMessengerService.printWinner(winnerList);
    }

}

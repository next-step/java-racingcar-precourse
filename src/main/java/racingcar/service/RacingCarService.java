package racingcar.service;

import racingcar.domain.RacingCar;
import racingcar.domain.RacingCarList;
import racingcar.domain.WinnerRacingCarList;

import java.util.ArrayList;
import java.util.List;

public class RacingCarService {

    public RacingCarList createRacingCar(List<String> carList) {
        List<RacingCar> racingCarList = new ArrayList<>();
        for (String name : carList) {
            racingCarList.add(RacingCar.of(name));
        }
        return RacingCarList.of(racingCarList);
    }

    public void racingCarMove(RacingCarList racingCar) {
        racingCar.racingCarMove();
    }

    public int racingCarMaxPosition(RacingCarList racingCar) {
        return racingCar.racingCarMaxPosition();
    }

    public WinnerRacingCarList racingCarWinner(RacingCarList racingCar, int maxPosition) {
        List<RacingCar> winnerRacingCar = racingCar.racingCarWinner(maxPosition);
        return WinnerRacingCarList.of(winnerRacingCar);
    }

}

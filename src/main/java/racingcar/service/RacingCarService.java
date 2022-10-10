package racingcar.service;

import racingcar.domain.Cars;

public class RacingCarService {

    /**
     * 레이싱을 1턴 진행한다
     *
     * @param cars 경주 할 자동차 리스트
     */
    public void raceOneTurn(Cars cars) {
        cars.race();
    }
}

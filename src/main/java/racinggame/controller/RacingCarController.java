package racinggame.controller;

import racinggame.model.RacingCar;

import java.util.Map;

public class RacingCarController {
    RacingCar racingCar = new RacingCar();

    public void initRacingCar(String carNames) {
        racingCar = new RacingCar(carNames);
    }

    public void setCarNames(String carNames) {
        racingCar.setCarNames(carNames);
    }

    public void setRaceCount(int count) {
        racingCar.setRaceCount(count);
    }

    public Map<String, Integer> race(){
        return racingCar.race();
    }

    public String getWinnerCarNames(){
        return racingCar.getWinnerCarNames();
    }

    public int getRaceCount(){
        return racingCar.getRaceCount();
    }
}

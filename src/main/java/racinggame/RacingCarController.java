package racinggame;

import java.util.Map;

public class RacingCarController {
    RacingCar racingCar;

    public void initRacingCar(String carNames) {
        racingCar = new RacingCar(carNames);
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

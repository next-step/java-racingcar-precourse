package model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Car {

    private final int DEFAULT_NUMBER = 0;
    private final Map< String, Integer > carInfo = new HashMap< String, Integer>();

    private int racingCount;

    public Map<String, Integer> getCarInfo() {
        return carInfo;
    }

    public void setCarNames(String carNames) {
        for (String str : carNames.split(",")) {
            this.carInfo.put(str, DEFAULT_NUMBER);
        }
    }

    public int getRacingCount() {
        return racingCount;
    }

    public void setRacingCount(int racingCount) {
        this.racingCount = racingCount;
    }
}

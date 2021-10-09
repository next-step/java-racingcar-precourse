package model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Car {

    private final Map< String, Integer > carInfo = new HashMap< String, Integer>();
    private int DEFAULT_NUMBER = 0;

    public Map<String, Integer> getCarInfo() {
        return carInfo;
    }

    public void setCarInfo(String carNames) {
        for (String str : carNames.split(",")) {
            this.carInfo.put(str, DEFAULT_NUMBER);
        }
    }
}

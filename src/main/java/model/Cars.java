package model;

import java.util.HashMap;
import java.util.Map;

public class Cars {

    private Map<String, String> cars = new HashMap<>();

    public void setCars(String[] carNames) {
        for (String carName : carNames) {
            this.cars.put(carName, "");
        }
    }

    public Map<String, String> getCars() {
        return this.cars;
    }
}

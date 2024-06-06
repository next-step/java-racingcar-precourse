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

    public void addDistance(String carName) {
        String curDist = this.cars.get(carName);
        this.cars.put(carName, curDist+"-");
    }

    public Map<String, String> getCars() {
        return this.cars;
    }
}

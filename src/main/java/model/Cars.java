package model;

import java.util.HashMap;

public class Cars {

    private HashMap<String, String> cars = new HashMap<>();

    public void setCars(String[] carNames) {
        for (String carName : carNames) {
            this.cars.put(carName, "");
        }
    }

    public void addDistance(String carName) {
        String curDist = this.cars.get(carName);
        this.cars.put(carName, curDist + "-");
    }

    public HashMap<String, String> getCars() {
        return this.cars;
    }
}

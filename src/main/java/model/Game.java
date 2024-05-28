package model;

import java.util.*;

public class Game {

    private Map<String, String> carPosition = new HashMap<>();

    public Game(List<String> carNames) {
        for (String carName : carNames) {
            carPosition.put(carName, "");
        }
    }

    public void advance(String carName) {
        String currentPosition = carPosition.get(carName);
        carPosition.put(carName, currentPosition + "-");
    }

    public Map<String, String> getCarPosition() {
        return carPosition;
    }
}

package model;

import java.util.*;

public class Game {

    private final Map<String, String> carPosition;

    public Game(List<String> carNames) {
        carPosition = new HashMap<>();
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

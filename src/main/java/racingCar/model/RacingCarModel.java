package racingCar.model;

import java.util.HashMap;
import java.util.Map;

public class RacingCarModel {

    private Map<String, Integer> carStatus;
    private int attempts;

    public RacingCarModel() {
        carStatus = new HashMap<>();
    }

    public void initCarStats(String[] carName) {
        for (String name : carName) {
            this.carStatus.put(name, 0);
        }
    }

    public int getAttempts() {
        return attempts;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }

    public Map<String, Integer> getCarStatus() {
        return carStatus;
    }
}

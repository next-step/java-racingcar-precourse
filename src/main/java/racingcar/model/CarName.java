package racingcar.model;

import racingcar.RacingCarConstants;

public class CarName {
    private final String name;

    public CarName(String name) {
        validCarName(name);
        this.name = name;
    }

    private void validCarName(String name) {
        if (name.isEmpty() || name.length() > RacingCarConstants.MAX_CAR_NAME_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    public String getName() {
        return name;
    }
}

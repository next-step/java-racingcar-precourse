package racingcar.model;

import racingcar.RacingCarConstants;
import racingcar.model.Message.ErrorMessage;

public class CarName {
    private final String name;

    public CarName(String name) {
        validCarName(name);
        this.name = name;
    }

    private void validCarName(String name) {
        if (name.isEmpty() || name.length() > RacingCarConstants.MAX_CAR_NAME_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_INPUT_CAR_NAMES);
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object other) {
        if(!(other instanceof CarName)){
            return false;
        }
        CarName cn = (CarName) other;
        return (cn.name).equals(name);
    }
}

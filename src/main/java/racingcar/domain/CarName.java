package racingcar.domain;

import static racingcar.constant.Constant.*;

public class CarName {
    private String name;

    public CarName(String name) {
        validationName(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void validationName(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(INPUT_NAME_LENGTH);
        }
    }
}

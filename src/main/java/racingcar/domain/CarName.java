package racingcar.domain;

import racingcar.exception.domain.CarNameException;

public class CarName {

    private static final Integer MIN_CAR_NAME_LENGTH = 1;
    private static final Integer MAX_CAR_NAME_LENGTH = 5;

    private String name;

    public CarName(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (name.length() < MIN_CAR_NAME_LENGTH || name.length() > MAX_CAR_NAME_LENGTH) {
            throw new CarNameException();
        }
    }

    public boolean equals(String name) {
        return this.name.equals(name);
    }

    public String getName() {
        return name;
    }
}

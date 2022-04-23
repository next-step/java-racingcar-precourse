package racingcar.model;

import static racingcar.common.ErrorMessage.NAME_TO_LONG;

public class Car {
    private static final int NAME_MAX_LENGTH = 5;

    private final String name;

    private Car(String name) {
        this.name = name;
    }

    public static Car create(String name) {
        if(name.length()>NAME_MAX_LENGTH)
            throw new IllegalArgumentException(NAME_TO_LONG.text());
        return new Car(name);
    }

    public String getName() {
        return this.name;
    }
}

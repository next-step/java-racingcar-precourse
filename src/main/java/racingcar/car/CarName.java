package racingcar.car;

import org.junit.platform.commons.util.StringUtils;

public class CarName {

    private static final int MAX_NAME_LENGTH = 5;
    private final String name;

    public CarName(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (StringUtils.isBlank(name)) {
            throw new IllegalArgumentException(CarErrorStatus.BLANK.printMessage());
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(CarErrorStatus.NAME_OVER_LENGTH.printMessage());
        }
    }

    public String getName() {
        return this.name;
    }
}

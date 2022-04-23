package racingcar.domain;

import racingcar.constant.Message;

public class CarName {

    public static final int MAX_LEN = 5;
    public static final int MIN_LEN = 0;
    private final String name;

    public CarName(String name) {
        if (name.length() <= MIN_LEN || name.length() > MAX_LEN) {
            throw new IllegalArgumentException(Message.ERR_NAME_LEN);
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

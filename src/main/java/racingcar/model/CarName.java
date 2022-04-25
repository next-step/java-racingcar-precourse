package racingcar.model;

import racingcar.view.Message;

public class CarName {
    public static final int MAX_LENGTH = 5;
    private String name;

    public CarName() {
        name = "";
    }

    public CarName(String name) throws IllegalArgumentException {
        validationForCarNameLength(name);
        this.name = name;
    }

    private void validationForCarNameLength(String name) {
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(Message.getNameCanNotBeMoreThen5Digits());
        }
    }

    public String getName() {
        return this.name;
    }
}

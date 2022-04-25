package racingcar.model;

import racingcar.utils.StringValidator;

public class Name {

    private final String name;

    public Name(String name) {
        StringValidator.lengthCheck(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

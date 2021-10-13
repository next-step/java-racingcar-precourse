package racinggame.domain;

import racinggame.domain.exceptions.CarException;

public class Name {
    private String name;

    public Name(String name) {
        validate(name);
        this.name = name;
    }
    private void validate(String carName) {
        if (carName.length() > 5) {
            throw new CarException("[ERROR] 다섯자 미만의 이름을 입력해 주세요");
        }
    }

    public String getName() {
        return name;
    }
}

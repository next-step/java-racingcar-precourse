package racinggame.car;

import javax.naming.LimitExceededException;

public class CarName {
    private String name;

    public CarName() {}

    public CarName(String name) throws LimitExceededException {
        validateCarName(name);
        this.name = name;
    }

    private void validateCarName(String name) throws LimitExceededException {
        if (name == null || name.equals("")) {
            throw new NullPointerException("자동차 이름을 입력해야 합니다.");
        }
        if (name.length() > 5) {
            throw new LimitExceededException("자동차 이름은 최대 5글자입니다.");
        }
    }

    public String get() {
        return name;
    }

    public String toString() {
        if (name == null) {
            return "";
        }
        return name;
    }
}

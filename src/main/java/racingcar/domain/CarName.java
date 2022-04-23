package racingcar.domain;


public class CarName {
    private static final int MAX_NAME_LENGTH = 5;
    private final String name;

    public CarName(String name) {
        this.validCarName(name);
        this.name = name;
    }

    private void validCarName(String name) {
        if (isEmpty(name)) {
            throw new IllegalArgumentException("차 이름을 지정해야 합니다.");
        }
        if (isOverMaxNameLength(name)) {
            throw new IllegalArgumentException("차 이름은 5자 이하만 가능합니다.");
        }
    }

    private boolean isOverMaxNameLength(String name) {
        return name.length() > MAX_NAME_LENGTH;
    }

    private boolean isEmpty(String name) {
        return name == null || name.length() == 0;
    }

    public String getName() {
        return this.name;
    }
}

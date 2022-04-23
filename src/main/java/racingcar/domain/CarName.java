package racingcar.domain;

public class CarName {
    private static final int MAX_NAME_LENGTH = 5;

    private String name;

    public CarName(String name) {
        validLength(name);
        this.name = name;
    }

    private void validLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차의 이름은 5자 이하만 가능합니다");
        }
    }

    public String getName() {
        return name;
    }
}
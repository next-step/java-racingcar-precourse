package racingcar;

public class CarName {
    public static final int MAX_LENGTH = 5;

    String name;

    public CarName(String name) {
        if(isInvalidName(name))
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 5자 이내여야 합니다.");
        this.name = name;
    }

    private boolean isInvalidName(String name) {
        return name.length() > 5;
    }

    public String getName() {
        return name;
    }
}

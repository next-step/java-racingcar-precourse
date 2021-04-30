package model;

public class CarName {
    public static final int MAX_NAME_SIZE = 5;

    private final String name;

    public CarName(String name) {
        validateNameSize(name);
        this.name = name;
    }

    private void validateNameSize(String name) {
        if (name.length() > MAX_NAME_SIZE) {
            throw new IllegalArgumentException("자동차 이름은 최대 5자까지만 가능합니다.");
        }
    }

    public String getName() {
        return name;
    }
}

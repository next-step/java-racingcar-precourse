package racingcar.models;

public class Car {
    private final String name;

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    public static void validateName(String name) throws IllegalArgumentException {
        if (name.length() > 5) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름이 너무 깁니다.");
        }
    }

    public String getName() {
        return name;
    }
}

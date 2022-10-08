package racingcar.domain;

public class CarName {
    private final String name;

    private CarName(String name) {
        this.name = name;
    }

    public static CarName of(String name) {
        String trimmed = name.trim();
        validateLength(trimmed);
        return new CarName(trimmed);
    }

    public String getName() {
        return name;
    }

    private static void validateLength(String name) {
        if (!(name.length() >= 1 && name.length() <= 5)) {
            throw new IllegalArgumentException("[ERROR] 차량명은 1글자 이상, 5글자 이하가 되어야합니다");
        }
    }
}

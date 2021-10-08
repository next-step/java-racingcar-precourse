package racinggame.domain;

public class CarName {
    private final int MAX_NAME_LENGTH = 5;
    private final String name;

    public CarName(String name) {
        validateLength(name);
        this.name = name;
    }

    private void validateLength(String name) {
        if (name == null || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(String.format("[ERROR] 이름은 최대 %s자 까지 가능합니다.", MAX_NAME_LENGTH));
        }
    }

    public String getName() {
        return name;
    }
}

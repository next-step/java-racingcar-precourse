package racingcar.domain;

public class Car {
    private static final int NAME_LENGTH_LIMIT = 5;

    private String name;
    private int forwardDistance;

    public Car(String name, int forwardDistance) {
        this.name = name;
        this.forwardDistance = forwardDistance;
    }

    private void validate(String name) {
        if (name.length() > NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException("[ERROR] 이름은 5자 이하만 가능합니다.");
        }
    }

    public String getName() {
        return name;
    }
}

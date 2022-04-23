package racingcar;

public class Car {

    private final String name;
    private int distance;

    private static final int FORWARD = 4;
    private static final int NAME_LIMIT = 5;

    public Car() {
        this.name = "";
    }

    public Car(String name) throws IllegalArgumentException {
        validateName(name);
        this.name = name;
    }

    public Car(String name, int distance) {
        this(name);
        this.distance = distance;
    }

    public void go(int moveDistance) {
        if (moveDistance >= FORWARD) {
            distance += 1;
        }
    }

    private void validateName(String name) {
        if(name == null) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 필수이다.");
        }

        if(name.length() > NAME_LIMIT) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 5차 이하여야한다.");
        }
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }
}

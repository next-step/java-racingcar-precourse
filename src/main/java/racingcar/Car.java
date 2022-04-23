package racingcar;

public class Car {

    private final String name;
    private int distance;

    private static final int FORWARD = 4;

    public Car() {
        this.name = "";
    }

    public Car(String name) throws IllegalArgumentException {
        this.name = name;

        if (!validateName()) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 5차 이하여야합니다.");
        }
    }

    public void go(int moveDistance) {
        if (moveDistance >= FORWARD) {
            distance += 1;
        }
    }

    private boolean validateName() {
        return name.length() <= 5;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }
}

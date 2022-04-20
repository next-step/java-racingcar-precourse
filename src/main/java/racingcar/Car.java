package racingcar;

public class Car {

    private final String name;
    private int distance;

    public Car() {
        this.name = "";
    }

    public Car(String name) {
        this.name = name;

        if (!validateName()) {
            throw new IllegalArgumentException();
        }
    }

    public void go(int randomNumber) {
        if (randomNumber > 3) {
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

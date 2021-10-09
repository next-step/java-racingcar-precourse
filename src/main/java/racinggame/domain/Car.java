package racinggame.domain;

public class Car {
    private final String name;
    private int step;

    public Car(String name) {
        this.name = name;
        this.step = 0;
    }

    public String getName() {
        return name;
    }

    public void moveForward() {
        step++;
    }

    public int getStep() {
        return step;
    }
}

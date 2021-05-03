package domain;

public class Car {
    public static final int START_POSITION = 0;
    private final String name;
    private int position;

    public Car(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차이름은 5자이하만 가능");
        }
        this.position = START_POSITION;
        this.name = name;
    }

    public int moveForward() {
        return ++position;
    }

    public int stop() {
        return 0;
    }

    public String name() {
        return name;
    }
}

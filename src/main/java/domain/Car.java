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

    public int movable(int condition) {
        if (condition < 0 || condition > 9) {
            throw new IllegalArgumentException("0 ~ 9사이만 가능");
        }
        if (condition >= 4) {
            return move();
        }
        return stop();
    }

    private int move() {
        return ++position;
    }

    public int stop() {
        return position;
    }

    public String name() {
        return name;
    }
}

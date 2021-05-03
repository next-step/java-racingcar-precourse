package racingcar;

import java.util.Random;

public class Car implements Comparable<Car> {
    private static final String DEFAULT_NAME = "ProjectCar";

    private String name;
    private int position;

    public boolean isMovable(int num) {
        return (num >= 4);
    }

    public void move() {
        position++;
    }

    public String printCurrentPosition() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(name);
        stringBuilder.append(":");

        for (int i = 0; i < position; i++) {
            stringBuilder.append("-");
        }

        return stringBuilder.toString();
    }

    public String toString() {
        return this.name;
    }

    public Car() {
        this(DEFAULT_NAME);
    }

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public int draw() {
        Random random = new Random();
        int picked = random.nextInt(10);

        if (isMovable(picked)) move();
        return picked;
    }

    @Override
    public int compareTo(Car that) {
        return Integer.compare(this.position, that.position);
    }
}

package racingcar.model;

public class Car {
    private static final int MAX_SIZE = 5;
    private String name;

    Car(String name) {
        if (MAX_SIZE < name.length())
            throw new IllegalArgumentException("Car name length is logger than " + MAX_SIZE);
        this.name = name;
    }
}

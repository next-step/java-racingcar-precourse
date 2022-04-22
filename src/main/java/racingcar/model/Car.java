package racingcar.model;

public class Car {
    private final String name;
    private static final int NAME_MAX_LENGTH = 5;
    private static final int NAME_MIN_LENGTH = 1;

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    public void validateName(String name) {
        validateNameLength(name);
    }

    public void validateNameLength(String name) {
        if(name.length() > NAME_MAX_LENGTH || name.length() < NAME_MIN_LENGTH) {
            throw new IllegalArgumentException();
        }
    }
}

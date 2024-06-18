package racingcar.entity;

public class RacingCar {
    private static final int MAXIMUM_NAME_LENGTH = 5;

    private final String name;
    private int location;

    public RacingCar(final String name) {
        this.name = name.trim();
        this.location = 0;

        validate();
    }

    public String getName() {
        return name;
    }

    public int getLocation() {
        return location;
    }

    public void forward() {
        location++;
    }

    private void validate() {
        if (name.isEmpty() || name.length() > MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException("wrong car name : " + name);
        }
    }
}

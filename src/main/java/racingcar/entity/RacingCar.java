package racingcar.entity;

public class RacingCar {
    private final String name;
    private int location;

    public RacingCar(String name) {
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
        if (name.isEmpty() || name.length() > 5) {
            throw new IllegalArgumentException("wrong car name : " + name);
        }
    }
}

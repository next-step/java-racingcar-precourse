package racinggame.vo;

import racinggame.environments.GlobalVariables;

public class CarLocation {
    private static final String LOCATION_INDICATOR = "-";

    private int location;

    public CarLocation() {
        this.location = GlobalVariables.START_CAR_LOCATION;
    }

    public CarLocation(int location) {
        this.location = location;
    }

    public CarLocation(CarLocation other) {
        this.location = other.get();
    }

    public void increase() {
        this.location++;
    }

    public int get() {
        return this.location;
    }

    public Boolean isGreaterThan(CarLocation other) {
        return this.location > other.get();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CarLocation)) return false;
        CarLocation that = (CarLocation) o;

        return location == that.location;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < this.location; i++) {
            builder.append(LOCATION_INDICATOR);
        }

        return builder.toString();
    }
}

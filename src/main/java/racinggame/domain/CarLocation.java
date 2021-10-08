package racinggame.domain;

public class CarLocation {

    private final static int INITIAL_LOCATION_VALUE = 0;
    private final static String SYMBOL = "-";

    private int locationValue;

    public CarLocation(int locationValue) {
        this.locationValue = locationValue;
    }

    public static CarLocation createLocation() {
        return new CarLocation(INITIAL_LOCATION_VALUE);
    }

    public static CarLocation from(CarLocation location) {
        return new CarLocation(location.getLocationValue());
    }

    public int getLocationValue() {
        return locationValue;
    }

    public void move() {
        this.locationValue++;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < locationValue; i++) {
            sb.append(SYMBOL);
        }
        return sb.toString();
    }
}

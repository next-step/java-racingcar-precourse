package racinggame.domain;

public class CarLocation {

    private int locationValue;

    public CarLocation(int locationValue) {
        this.locationValue = locationValue;
    }

    public int getLocationValue() {
        return locationValue;
    }

    public void move() {
        this.locationValue++;
    }
}

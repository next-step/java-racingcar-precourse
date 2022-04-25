package racingcar.domain;

public class RacingCarLocation {
    private int location = 0;

    public int currentLocation() {
        return location;
    }

    public void addLocation() {
        location++;
    }
}

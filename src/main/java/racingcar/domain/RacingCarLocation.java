package racingcar.domain;

public class RacingCarLocation {

    private static final int INITIALIZE_LOCATION = 0;
    private static final int FORWARD_SIZE = 1;
    private int location;

    public RacingCarLocation() {
        this.location = INITIALIZE_LOCATION;
    }

    public int getLocation() {
        return location;
    }

    public void updateLocation(RacingStatus racingStatus) {
        if(racingStatus.isForward()) {
            location += FORWARD_SIZE;
        }
    }
}

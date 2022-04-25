package racingcar.domain;

public class RacingCar {
    public static final int MOVING_CONDITION = 4;
    public static final String MARK = "-";

    private final RacingCarName carName;
    private final RacingCarLocation racingCarLocation;

    public RacingCar(RacingCarName carName) {
        this.carName = carName;
        this.racingCarLocation = new RacingCarLocation();
    }

    public void move(int random) {
        if (MOVING_CONDITION <= random) {
            this.racingCarLocation.addLocation();
        }

        System.out.println(currentLocationMark());
    }

    public int getCurrentLocation() {
        return racingCarLocation.currentLocation();
    }

    public String getCarName() {
        return carName.getName();
    }

    public String currentLocationMark() {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < racingCarLocation.currentLocation(); i++) {
            stringBuilder.append(MARK);
        }

        return String.format("%s : %s", this.carName.getName(), stringBuilder);
    }
}

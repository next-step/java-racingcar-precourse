package racingcar.domain;

public class Racing {

    private final Cars cars;
    private final Track track;
    private Winners winners;

    public Racing(Cars cars, Track track) {
        this.cars = cars;
        this.track = track;
    }

    public static Racing of(Cars cars, Track track) {
        return new Racing(cars, track);
    }

    public Cars getCars() {
        return cars;
    }

    public Track getTrack() {
        return track;
    }

    public Winners getWinners() {
        return winners;
    }

    public void setWinners(Winners winners) {
        this.winners = winners;
    }

    public boolean isEnd() {
        return !getWinners().isEmpty();
    }
}

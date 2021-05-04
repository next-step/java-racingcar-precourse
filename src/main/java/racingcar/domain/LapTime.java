package racingcar.domain;

public class LapTime {
    private int lap;
    private CarName carName;
    private Distance distance;

    public LapTime(int lap, String name, int distance) {
        this.lap = lap;
        this.carName = new CarName(name);
        this.distance = new Distance(distance);
    }

    public String getCarName() {
        return carName.getName();
    }

    public int getDistance() {
        return distance.getDistance();
    }

    public int getLap() {
        return lap;
    }
}

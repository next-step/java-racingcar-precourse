package racingcar.domain;

public class RacingCar {
    private CarName name;
    private Distance distance;
    private final int FORWARD_MIN_VALUE = 3;

    public RacingCar(String name, int maxDistance) {
        this.name = new CarName(name);
        this.distance = new Distance(maxDistance);
    }

    public void move(int move_num){
        if (move_num > FORWARD_MIN_VALUE) {
            distance.increase();
        }
    }

    public String getName() {
        return name.getName();
    }

    public int getDistance() {
        return distance.getDistance();
    }
}

package domain;

public class RacingCar {
    private static final int MOVE_CONDITION = 4;

    private RacingCarName racingCarName;
    private Distance distance;

    public RacingCar(final String name, final int distance) {
        this.racingCarName = new RacingCarName(name);
        this.distance = new Distance(distance);
    }

    public void move(final int num){
        if(num >= MOVE_CONDITION){
            this.distance = distance.increase();
        }
    }

    public RacingCarName getRacingCarName() {
        return racingCarName;
    }

    public Distance getDistance() {
        return distance;
    }
}

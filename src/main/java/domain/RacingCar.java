package domain;

public class RacingCar implements Comparable<RacingCar> {
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

    public String getRacingCarName() {
        return racingCarName.carName();
    }

    public Integer getDistance() {
        return distance.location();
    }

    public boolean isSameDistance(RacingCar competeCar) {
        return this.distance.location() == competeCar.distance.location();
    }

    @Override
    public int compareTo(RacingCar competeCar) {
        return this.distance.location() - competeCar.distance.location();
    }
}

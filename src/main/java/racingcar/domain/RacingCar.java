package racingcar.domain;

public class RacingCar implements Comparable<RacingCar> {

    private final Name name;
    private final Position position;
    private final MovingStrategy movingStrategy;

    public RacingCar(String name, MovingStrategy movingStrategy) {
        this.name = new Name(name);
        this.position = new Position();
        this.movingStrategy = movingStrategy;
    }

    public void move(int number) {
        if (movingStrategy.decide(number)) {
            position.goForwardOneStep();
        }
    }

    public boolean hasSameDistance(RacingCar compareRacingCar) {
        return this.position.equals(compareRacingCar.position);
    }

    public String getRacingCarName() {
        return name.toString();
    }

    @Override
    public int compareTo(RacingCar o) {
        return this.position.compareTo(o.position);
    }

    @Override
    public String toString() {
        return name + " : " + position;
    }
}

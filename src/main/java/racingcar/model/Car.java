package racingcar.model;

public class Car {

    private final Name name;
    private final Position position;
    private final RandomNumber randomNumber;

    public Car(Name name) {
        this.name = name;
        this.position = new Position();
        this.randomNumber = new RandomNumber();
    }

    public void play() {
        if (isMovable(randomNumber.next())) {
            move();
        }
    }

    public void move() {
        position.increase();
    }

    boolean isMovable(int randomNumber) {
        if (randomNumber >= 4) {
            return true;
        }
        return false;
    }

    public Position getPosition() {
        return this.position;
    }

    public Name getName() {
        return this.name;
    }
}

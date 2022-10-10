package racingcar.domain;

public class Car {

    private final Name name;
    private final Move move;

    public Car(String name) {
        this.name = new Name(name);
        this.move = new Move();
    }

    public Name getName() {
        return name;
    }

    public Move getMove() {
        return move;
    }

    public static Car of(String name) {
        return new Car(name);
    }
}

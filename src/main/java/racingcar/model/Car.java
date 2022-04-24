package racingcar.model;

public class Car {

    private final String name;
    private int position;

    private MovableStrategy movableStrategy;

    public Car(String name) {
        this.name = name;
    }

    public Car(String name, MovableStrategy movableStrategy) {
        this.name = name;
        this.movableStrategy = movableStrategy;
    }

    public static Car of(String name, MovableStrategy movableStrategy) {
        return new Car(name, movableStrategy);
    }

    public String getName() {
        return name;
    }

    public int curPosition() {
        return position;
    }

    public void move() {
        if (movableStrategy.isMovable()) {
            this.position += 1;
        }
    }

    public boolean isWinner(int round) {
        if (this.curPosition() == round) {
            return true;
        }

        return false;
    }

}

package racinggame.domain;

public class Car {

    private CarName carName;
    private Position position;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        this.carName = new CarName(name);
        this.position = new Position(position);
    }

    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.canMove()) {
            position.move();
        }
    }

    public int getPosition() {
        return position.getValue();
    }

    public String getName() {
        return carName.getValue();
    }
}

package racinggame;

public class Car {
    private CarName carName;
    private Position position;
    private MoveStrategy moveStrategy;

    public Car(CarName carName, MoveStrategy moveStrategy) {
        this.carName = carName;
        this.position = Position.of();
        this.moveStrategy = moveStrategy;
    }

    public static Car of(String carName, MoveStrategy moveStrategy) {
        return new Car(CarName.of(carName), moveStrategy);
    }

    public String getCarName() {
        return carName.getCarName();
    }

    public void move(){
        position.move(moveStrategy.move());
    }

    public boolean matchPostion(int position) {
        return this.position.matchPosition(position);
    }
}

package racingcar;

/**
 * author : citizen103
 */
public class Car {

    private final CarName carName;
    private Movement movement;

    public Car(String carName) {
        this(new CarName(carName));
    }

    private Car(CarName carName) {
        this(carName, new Movement());
    }

    private Car(CarName carName, Movement movement) {
        this.carName = carName;
        this.movement = movement;
    }

    public void move(int randomValue) {
        if (movement.isMove(randomValue)) {
            movement.move();
        }
        print();
    }

    private void print() {
        System.out.println(String.format("%s : %s", carName.getName(), movement.getHyphen()));
    }

    public boolean isMovementSame(int askNum) {
        return movement.isMovementSame(askNum);
    }

    public String getCarName() {
        return carName.getName();
    }
}

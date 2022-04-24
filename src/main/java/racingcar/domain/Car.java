package racingcar.domain;

import java.util.Objects;

/**
 *  자동차 클래스
 *  차의 이름과 현재의 position을 가지고 있는 객체
 * */
public class Car {
    private final CarName carName;
    private final Position position = new Position(0);
    private static final String SEPARATOR = " : ";

    public Car(String name) {
        carName = new CarName(name);
    }

    // command를 위치를 이동하는 메서드
    public MoveStatus command(int command) {
        MoveStatus moveStatus = MoveStatus.getStatus(command);
        if (MoveStatus.MOVE.equals(moveStatus)) {
            move();
        }
        return moveStatus;
    }

    public String getName() {
        return carName.getName();
    }

    // 위치를 이동하는 메서드
    private void move() {
        position.add();
    }

    public Position getPosition() {
        return position;
    }

    public int moveLength() {
        return position.getPosition();
    }

    // 이름이 같으면 같은 차이다.
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return Objects.equals(carName, car.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName);
    }

    @Override
    public String toString() {
        return carName.getName() + SEPARATOR + position;
    }

}

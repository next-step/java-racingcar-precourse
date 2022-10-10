package racingcar.model.car;

import java.util.Objects;
import racingcar.model.strategy.MoveStrategy;
import racingcar.view.Output;

/**
 * 자동차 객체
 *
 * @author YONGSEOK CHOI
 * @version 1.0 2022.10.09
 */
public class Car implements Comparable<Car> {

    private final CarName name;
    private final CarPosition position;

    public Car(String name) {
        this.name = new CarName(name);
        this.position = new CarPosition();
    }

    public CarName getCarName() {
        return name;
    }

    public CarPosition getCarPosition() {
        return position;
    }

    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.isMovable()) {
            position.moveOneStep();
        }
    }

    @Override
    public int compareTo(Car c) {
        if (this.position.lesserThan(c.position))//길이 비교
        {
            return -1;
        }
        return 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return Objects.equals(getCarName(), car.getCarName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCarName());
    }

    public void printCarPositionWithName() {
        Output.printCarPositionByCar(
                String.format("%s : %s", getCarName().toString(), getCarPosition().printCarPosition()));
    }

}

package racingcar.model.car;

import racingcar.constant.Config;
import racingcar.vo.CarName;

public class Car {
    private CarName carName;
    private Position position;
    private Distance distance;

    public String getName() {
        return this.carName.getCarName();
    }

    public Car(CarName carName) {
        this.carName = carName;
        this.distance = new Distance();
        this.position = new Position();
    }

    public int getDistance() {
        return distance.getDistance();
    }

    public void setDistance(int distance) {
        if (distance > Config.MOVING_STANDARD_NUM) {
            this.distance.move();
            this.position.move();
        }
    }

    public String getPosition() {
        return this.position.getPosition();
    }
}

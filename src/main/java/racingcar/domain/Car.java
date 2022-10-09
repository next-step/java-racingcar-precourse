package racingcar.domain;

import racingcar.common.CarMessage;
import racingcar.common.ExcMessage;

public class Car {

    private final CarName carName;

    private final Position position;

    public Car(CarName carName,Position position){
        this.carName = carName;
        this.position = position;
    }

    public CarName getCarName() {
        return carName;
    }

    public Position getPosition() {
        return position;
    }

}

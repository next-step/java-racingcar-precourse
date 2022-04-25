package racingcar.domain;

import racingcar.utils.DrivingCondition;

public class Car {

    private final CarName carName;
    private Mileage mileage;

    public Car(String carName) {
        this.carName = new CarName(carName);
        this.mileage = Mileage.init();
    }

    public void run(int randomNumber) {
        if (DrivingCondition.isPossible(randomNumber)) {
            mileage = mileage.plus();
        }
    }

    public CarName getCarName() {
        return carName;
    }

    public Mileage getMileage() {
        return mileage;
    }

    public void record(Round round) {
        round.record(carName, mileage);
    }
}

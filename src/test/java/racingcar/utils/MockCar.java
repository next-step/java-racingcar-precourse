package racingcar.utils;

import racingcar.domain.Car;
import racingcar.domain.CarName;

public class MockCar extends Car {
    private boolean isCalled = false;

    public MockCar(CarName carName) {
        super(carName);
    }

    @Override
    public void notifyObservers(Object arg) {
        super.notifyObservers(arg);
        this.isCalled = true;
    }

    public boolean isNotifyObserversCalled() {
        return isCalled;
    }
}

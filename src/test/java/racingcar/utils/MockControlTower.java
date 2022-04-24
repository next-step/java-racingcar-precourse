package racingcar.utils;

import racingcar.domain.Cars;
import racingcar.domain.ControlTower;

import java.util.Observable;

public class MockControlTower extends ControlTower {
    private boolean isReceived = false;

    public MockControlTower(Cars cars) {
        super(cars);
    }

    public boolean isReceivedObservable() {
        return this.isReceived;
    }

    @Override
    public void update(Observable o, Object arg) {
        this.isReceived = true;
    }
}

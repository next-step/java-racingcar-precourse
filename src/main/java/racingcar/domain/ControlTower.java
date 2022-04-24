package racingcar.domain;

import java.util.Observable;
import java.util.Observer;

public class ControlTower implements Observer {
    private final Locations locations;

    public ControlTower(Cars cars) {
        for (Car car : cars) {
            car.addObserver(this);
        }
        this.locations = new Locations(cars);
    }

    public Cars getAll() {
        return this.locations.getAll();
    }

    public Position getPosition(Car car) {
        return this.locations.getPosition(car);
    }

    public Cars getWinners() {
        return this.locations.winners();
    }

    @Override
    public void update(Observable o, Object arg) {
        this.locations.update((Car) o);
    }
}

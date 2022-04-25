package racingcar.domain.racetrack;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.car.accelpower.AccelPowerStrategy;
import racingcar.domain.car.Car;
import racingcar.domain.car.CarNames;

public class RaceTrack {

    private final List<Car> cars;
    private Lap lap;

    public RaceTrack(List<String> carNames) {
        this.cars = readyCars(carNames);
        this.lap = new Lap(0);
    }

    public RaceTrack(CarNames carNames) {
        this(carNames.getCarNames());
        this.lap = new Lap(0);
    }

    public RaceTrack(CarNames carNames, Lap lap) {
        this(carNames.getCarNames());
        this.lap = lap;
    }

    private List<Car> readyCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
        return cars;
    }

    public int carCount() {
        return cars.size();
    }

    public int getCurrentLap() {
        return lap.getCurrentLap();
    }

    public void raceEachLap(AccelPowerStrategy accelerationPowerStrategy) {
        lap.decrease();
        for (Car car : cars) {
            car.move(accelerationPowerStrategy);
        }
    }

    public boolean keepGoing() {
        return lap.getCurrentLap() > 0;
    }

    public List<Car> getCars() {
        return cars;
    }
}

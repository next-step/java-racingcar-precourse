package racingcar.racing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.car.Car;
import racingcar.car.CarLocation;
import racingcar.car.manager.Cars;

public class WinnerCars {

    private final Set<Car> winnerList = new HashSet<>();
    private final CarLocation winnerLocation;

    public WinnerCars(Cars cars) {
        this.winnerLocation = cars.highestLocation();
        this.initWinner(cars);
    }

    private void initWinner(Cars cars) {
        List<Car> carList = cars.getCarList();
        for (Car car : carList) {
            this.addIfWinner(car);
        }
    }

    private void addIfWinner(Car car) {
        if (!isWinner(car)) {
            return;
        }
        this.winnerList.add(car);
    }

    private boolean isWinner(Car car) {
        return car.location().equals(this.winnerLocation);
    }

    public RacingCarNames carNames() {
        List<String> carNames = new ArrayList<>();
        for (Car car : winnerList) {
            carNames.add(car.carName().name());
        }
        return new RacingCarNames(carNames);
    }
}

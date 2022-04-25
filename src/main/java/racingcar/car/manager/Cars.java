package racingcar.car.manager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import racingcar.car.Car;
import racingcar.car.CarFactory;
import racingcar.car.CarLocation;
import racingcar.car.CarName;
import racingcar.racing.RacingCarNames;

public class Cars {

    private final CarFactory carFactory;
    private final List<Car> carList;

    public Cars(RacingCarNames racingCarNames) {
        this(new CarFactory(), racingCarNames.getCarNames());
    }

    public Cars(CarFactory carFactory, List<CarName> carNames) {
        this.carFactory = carFactory;
        this.carList = new ArrayList<>();

        this.addCars(carNames);
    }

    public void addCar(CarName name) {
        Car car = this.carFactory.createCar(name);
        this.carList.add(car);
    }

    public void addCars(List<CarName> carNames) {
        for (CarName carName : carNames) {
            this.addCar(carName);
        }
    }

    public void tryMoveAllCar() {
        for (Car car : this.carList) {
            car.tryMove();
        }
    }

    public CarLocation highestLocation() {
        Car max = Collections.max(this.carList);
        return max.location();
    }

    public List<Car> getCarList() {
        return Collections.unmodifiableList(this.carList);
    }

}

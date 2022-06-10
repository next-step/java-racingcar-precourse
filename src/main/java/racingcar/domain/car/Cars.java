package racingcar.domain.car;

import racingcar.domain.name.Name;
import racingcar.domain.name.Names;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private List<Car> cars = new ArrayList<>();

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public Cars(Names names) {
        parkingCars(names);
    }

    public void parkingCars(Names names) {
        for (Name name: names.getNames()) {
            cars.add(new Car(name));
        }
    }

    public Cars move() {
        List<Car> carsRecords = new ArrayList<>();
        for (Car car : cars) {
            Car movedCar = car.move();
            carsRecords.add(movedCar);
        }
        return new Cars(carsRecords);
    }

    public List<Car> getCars() {
        return new ArrayList<>(cars);
    }

}

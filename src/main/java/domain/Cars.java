package domain;

import domain.history.CarHistories;
import domain.history.CarHistory;
import domain.name.CarName;
import domain.name.CarNames;
import domain.strategy.MoveStrategy;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> cars = new ArrayList<>();

    public Cars(CarNames carNames, MoveStrategy moveStrategy) {
        for(CarName carName : carNames.getNames()) {
            this.cars.add(new Car(carName, moveStrategy));
        }
    }

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void move() {
        for(Car car : cars) {
            car.move();
        }
    }

    public CarHistories getCarCurrentInfos() {
        List<CarHistory> histories = new ArrayList<>();
        for(Car car : cars) {
            histories.add(car.getCurrentInfo());
        }

        return new CarHistories(histories);
    }
}

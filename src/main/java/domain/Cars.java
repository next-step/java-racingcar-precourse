package domain;

import domain.strategy.MoveStrategy;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> cars;

    public Cars(CarNames carNames, MoveStrategy moveStrategy) {
        this.cars = new ArrayList<>();

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

    public Positions getPositions() {
        List<Position> positions = new ArrayList<>();
        for(Car car : cars) {
            positions.add(car.getPosition());
        }

        return new Positions(positions);
    }
}

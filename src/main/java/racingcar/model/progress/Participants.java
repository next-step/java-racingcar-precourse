package racingcar.model.progress;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.cars.Car;

public class Participants {
    private final List<Car> cars;

    private Participants(List<Car> cars) {
        this.cars = cars;
    }

    public static Participants of(List<Car> cars) {
        return new Participants(cars);
    }

    public void move() {
        for (Car car : cars) {
            car.move();
        }
    }

    public RaceSituation getRaceSituation() {
        return RaceSituation.of(this.createCarMoveHistories());
    }

    private List<CarMoveHistory> createCarMoveHistories() {
        List<CarMoveHistory> carMoveHistories = new ArrayList<>();
        for (Car car : cars) {
            carMoveHistories.add(CarMoveHistory.of(car));
        }
        return carMoveHistories;
    }
}

package racingcar.domain.game;

import java.util.List;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;

public class Game {
    private final Round round;
    private final Cars cars;

    private Game(Cars cars) {
        this.cars = cars;
        this.round = Round.from(0);
    }

    public static Game of(Cars cars) {
        return new Game(cars);
    }

    public void play() {
        this.cars.run();
        this.round.increase();
    }

    public Cars getCars() {
        return this.cars;
    }

    public Round getRound() {
        return this.round;
    }

    public List<Car> findMostMovedCars() {
        return this.cars.findMostMovedCars();
    }
}

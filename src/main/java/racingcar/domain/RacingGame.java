package racingcar.domain;

import racingcar.strategy.MovingStrategy;

import java.util.Collections;
import java.util.List;

public class RacingGame {
    private static final List<Car> DONE = Collections.emptyList();

    private final Cars cars;
    private Movement movement;

    public RacingGame(Cars cars, Movement movement) {
        this.cars = cars;
        this.movement = movement;
    }

    public List<Car> game(MovingStrategy movingStrategy) {
        if (!continuable()) {
            return DONE;
        }

        move(movingStrategy);
        return Collections.unmodifiableList(cars.getCarList());
    }

    public boolean continuable() {
        return movement.continuable();
    }

    private void move(MovingStrategy movingStrategy) {
        cars.move(movingStrategy);
        movement = movement.move();
    }
}

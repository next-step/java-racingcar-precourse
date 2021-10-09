package racinggame.domain;

import racinggame.domain.strategy.MoveStrategy;

import java.util.Objects;

public class RacingGame {

    private MoveStrategy moveStrategy;
    private Cars cars;

    public RacingGame(final MoveStrategy moveStrategy, final Cars cars) {
        this.moveStrategy = moveStrategy;
        this.cars = cars;
    }

    public RacingGame next() {
        cars.move(moveStrategy);
        return new RacingGame(moveStrategy, cars);
    }

    public Cars getCars() {
        return new Cars(cars);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingGame that = (RacingGame) o;
        return Objects.equals(cars, that.cars) && Objects.equals(moveStrategy, that.moveStrategy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars, moveStrategy);
    }
}

package domain;

import domain.strategy.MoveStrategy;
import domain.strategy.RandomMoveStrategy;

public class Game {
    private Cars cars;

    public Game(CarNames carNames) {
        this(carNames, new RandomMoveStrategy());
    }

    public Game(CarNames carNames, MoveStrategy moveStrategy) {
        this.cars = new Cars(carNames, moveStrategy);
    }
}

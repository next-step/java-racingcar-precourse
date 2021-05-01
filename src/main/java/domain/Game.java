package domain;

import domain.strategy.MoveStrategy;
import domain.strategy.RandomMoveStrategy;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Cars cars;
    private List<Positions> moveHistories = new ArrayList<>();

    public Game(CarNames carNames) {
        this(carNames, new RandomMoveStrategy());
    }

    public Game(CarNames carNames, MoveStrategy moveStrategy) {
        this.cars = new Cars(carNames, moveStrategy);
    }

    public void move(int times) {
        for(int i = 0; i<times; i++) {
            cars.move();
            moveHistories.add(cars.getPositions());
        }
    }

    public List<Positions> getMoveHistories() {
        return new ArrayList<>(moveHistories);
    }
}

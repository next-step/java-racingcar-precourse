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

    public void move(TryCount times) {
        for (int i = 0; i < times.getCount(); i++) {
            cars.move();
            moveHistories.add(cars.getPositions());
        }
    }

    public List<Positions> getMoveHistories() {
        return new ArrayList<>(moveHistories);
    }

    public Winners getWinners() {
        int lastIndex = moveHistories.size() - 1;

        return new Winners(moveHistories.get(lastIndex));
    }

}

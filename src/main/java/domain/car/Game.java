package domain.car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import domain.car.name.CarNames;
import domain.car.result.CarMoveResults;
import domain.car.strategy.MovableStrategy;
import domain.car.strategy.RandomMovableStrategy;
import domain.car.winner.Winners;

public class Game {

	private Cars cars;

	private List<CarMoveResults> allResult = new ArrayList<>();

	public Game(CarNames carNames) {
		this(carNames, new RandomMovableStrategy());
	}

	public Game(CarNames carNames, MovableStrategy movableStrategy) {
		cars = Cars.of(carNames, movableStrategy);
	}

	public void start(MoveCount moveCount) {
		for (int i = 0; i < moveCount.getCount(); i++) {
			allResult.add(cars.move());
		}
	}

	public List<CarMoveResults> getAllResult(){
		return Collections.unmodifiableList(allResult);
	}

	public Winners getWinners(){
		int lastIndex = allResult.size() - 1;
		return Winners.of(allResult.get(lastIndex));
	}

}

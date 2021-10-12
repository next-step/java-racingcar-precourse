package racinggame.controller;

import racinggame.domain.Car;
import racinggame.domain.GameResult;
import racinggame.domain.MoveCount;
import racinggame.domain.RacingCars;

public class GameRule {

	private RacingCars racingCars;
	private MoveCount moveCount;

	public GameRule(RacingCars racingCars, MoveCount moveCount) {
		this.racingCars = racingCars;
		this.moveCount = moveCount;
	}

	public String getGameResult(){
		return new GameResult(racingCars).getGameResult();
	}

	public void gameStart() {
		int count = this.moveCount.getCount();
		for (int i = 0; i < count; i++) {
			racing();
		}
	}

	private void racing() {
		for (Car car : this.racingCars.getRacingCars()) {
			car.moveCar();
			System.out.println(car.currentCars());
		}
		System.out.println();
	}
}

package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Car;
import racingcar.model.Game;

public class GameService {

	public void doGame(Game game, int turnCount) {
		for (int i = 0; i < turnCount; i++) {
			doTurn(game);
		}
	}

	public void doTurn(Game game) {
		for (Car car : game.getCarList()) {
			moveCar(car);
		}
	}

	public void moveCar(Car car) {
		if (isForward()) {
			car.moveForward();
		}
	}

	public boolean isForward() {
		int number = Randoms.pickNumberInRange(0, 9);
		if (number < 4) {
			return false;
		}
		return true;
	}
}

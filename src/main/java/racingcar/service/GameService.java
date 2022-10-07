package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Car;
import racingcar.model.Game;

public class GameService {

	public void doGame(Game game, int turnCount) {
		for (int i = 0; i < turnCount; i++) {
			doTurn(game);
			System.out.println(game.toString());
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

	public void printWinner(Game game) {
		int maxPosition = 0;
		String winnerStr = "";

		for (Car car : game.getCarList()) {
			maxPosition = getMaxPosition(maxPosition, car);
		}

		for (Car car : game.getCarList()) {
			winnerStr += getWinnerStr(winnerStr, maxPosition, car);
		}

		System.out.println("최종 우승자 : " + winnerStr);
	}

	public int getMaxPosition(int currentMaxPosition, Car car) {
		int currentPosition = car.getPosition().getPosition();
		if (currentMaxPosition <= currentPosition) {
			return currentPosition;
		}
		return currentMaxPosition;
	}

	public String getWinnerStr(String winnerStr, int maxPosition, Car car) {
		if (maxPosition != car.getPosition().getPosition()) {
			return "";
		}

		if (winnerStr != null && !winnerStr.equals("")) {
			return ", " + car.getName().toString();
		}

		return car.getName().toString();
	}
}

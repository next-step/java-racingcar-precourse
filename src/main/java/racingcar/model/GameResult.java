package racingcar.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import racingcar.code.ErrorCode;
import racingcar.exception.CarException;

public class GameResult {
	private List<String> moveResultList = new ArrayList<>();
	private String winner;
	private int gameCount;
	private Cars cars;

	public GameResult(GameResultBuilder gameResultBuilder) {
		this.gameCount = gameResultBuilder.gameCount;
		this.cars = gameResultBuilder.cars;
	}

	public Cars getCars() {
		return cars;
	}

	public int getGameCount() {
		return gameCount;
	}

	public List<String> getMoveResultList() {
		return moveResultList;
	}

	public String getWinner() {
		return winner;
	}

	public String convertCarListToMoveResultList() {
		StringBuilder stringBuilder = new StringBuilder();
		for (Car car : this.cars.getCarList()) {
			stringBuilder.append(car.getOutputMove());
			stringBuilder.append(System.lineSeparator());
		}
		return stringBuilder.toString();
	}

	public void moveCars() {
		do {
			cars.moveCars();
			moveResultList.add(convertCarListToMoveResultList());
			gameCount--;
		} while (gameCount > 0);
	}

	public void createWinner() {
		int maxForward = createMaxForward();
		StringBuilder stringBuilder = new StringBuilder();
		for (Car car : cars.getCarList()) {
			stringBuilder = validMaxForward(stringBuilder, car, maxForward);
		}
		this.winner = stringBuilder.toString();
	}

	public StringBuilder validMaxForward(StringBuilder sb, Car car, int maxForward) {
		if (car.getForward() == maxForward) {
			sb = setComma(sb);
			sb.append(car.getName());
		}
		return sb;
	}

	public StringBuilder setComma(StringBuilder sb) {
		if (sb.length() > 0) {
			sb.append(",");
		}
		return sb;
	}

	public int createMaxForward() {
		List<Integer> forwardList = new ArrayList<>();
		for (Car car : cars.getCarList()) {
			forwardList.add(car.getForward());
		}
		return Collections.max(forwardList);
	}

	public static class GameResultBuilder {
		private int gameCount;
		private Cars cars;

		public GameResultBuilder cars(Cars cars) {
			this.cars = cars;
			return this;
		}

		public GameResultBuilder gameCount(String gameCount) {
			this.gameCount = Integer.parseInt(validGameCount(gameCount));
			return this;
		}

		public String validGameCount(String gameCount) {
			if (!gameCount.matches("[0-9]+")) {
				throw new CarException(ErrorCode.INVALID_INPUT_GAME_COUNT_ERROR.getMessage());
			}
			return gameCount;
		}

		public GameResult build() {
			return new GameResult(this);
		}
	}
}

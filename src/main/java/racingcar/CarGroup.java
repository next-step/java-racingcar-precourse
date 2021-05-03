package racingcar;

import java.util.ArrayList;
import java.util.List;

public class CarGroup {
	private List<Car> cars;
	private int gameCount = 0;

	public CarGroup(List<String> carNames, String gameCount) {
		this.cars = mapCar(carNames);
		this.gameCount = isValidMoveCount(gameCount);
	}

	private int isValidMoveCount(String gameCount) {
		if (isPresentString(gameCount)) {
			throw new IllegalArgumentException("게임 진행 횟수를 입력하세요.");
		}

		if (!gameCount.chars().allMatch(Character::isDigit)) {
			throw new IllegalArgumentException("숫자만 입력 가능합니다.");
		}

		return Integer.parseInt(gameCount);
	}

	private boolean isPresentString(String moveCount) {
		return moveCount.trim().length() == 0 || moveCount == null;
	}

	private List<Car> mapCar(List<String> carNames) {
		if (isPresentCar(carNames)) {
			throw new IllegalArgumentException("게임을 진행할 자동차가 없습니다.");
		}

		List<Car> cars = new ArrayList<>();
		for (int i = 0; i < carNames.size(); i++) {
			cars.add(new Car(carNames.get(i)));
		}

		return cars;
	}

	private boolean isPresentCar(List<String> carNames) {
		return carNames.size() == 0 || carNames == null;
	}

	public void start() {
		for (int i = 0; i < gameCount; i++) {
			progressGameCount();
		}
	}

	public void progressGameCount() {
		for (Car car : this.cars) {
			car.isForward(Generator.randomNumber());
		}
	}
}

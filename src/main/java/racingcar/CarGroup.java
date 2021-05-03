package racingcar;

import java.util.ArrayList;
import java.util.List;

public class CarGroup {
	private List<Car> cars;
	private GameCount gameCount;

	public CarGroup(List<String> carNames, String gameCount) {
		this.cars = mapCar(carNames);
		this.gameCount = new GameCount(gameCount);
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
		System.out.println();
		System.out.println("실행결과");
		for (int i = 0; i < gameCount.getGameCount(); i++) {
			CarResult result = new CarResult();
			result.progressGameCount(cars);
			System.out.println();
		}
	}
}

package racingcar.domain.car.collect;

import java.util.List;

import racingcar.domain.car.CarName;

public class CarNames {
	private final List<CarName> carNames;

	public CarNames(List<CarName> carNames) {
		this.carNames = carNames;
	}

	public List<CarName> getCarNames() {
		return carNames;
	}

	@Override
	public String toString() {
		return "CarNames{" +
			"carNames=" + carNames +
			'}';
	}
}

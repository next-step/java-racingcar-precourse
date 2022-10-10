package racingcar.domain.car.collect;

import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

import racingcar.domain.car.CarName;

public class CarNames {
	private final List<CarName> carNames;

	public CarNames(List<CarName> carNames) {
		this.carNames = carNames;
	}

	public List<CarName> getCarNames() {
		return carNames;
	}

	public String join(CharSequence delimiter) {
		Objects.requireNonNull(delimiter);
		StringJoiner joiner = new StringJoiner(delimiter);
		for (CarName carName : carNames) {
			joiner.add(carName.name());
		}
		return joiner.toString();
	}

	@Override
	public String toString() {
		return "CarNames{" +
			"carNames=" + carNames +
			'}';
	}
}

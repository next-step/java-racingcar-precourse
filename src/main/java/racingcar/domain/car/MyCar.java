package racingcar.domain.car;

import racingcar.domain.car.factor.CarName;

public class MyCar implements Component {

	private CarName carName;
	private int distance;
	public MyCar(CarName carName, int distance) {
		this.carName = carName;
		this.distance = distance;
	}
	@Override
	public int getDistances() {
		return distance;
	}

	@Override
	public String toString() {
		return "MyCar{" +
			"carName=" + carName +
			", distance=" + distance +
			'}';
	}
}

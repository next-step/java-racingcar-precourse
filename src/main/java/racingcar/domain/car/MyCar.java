package racingcar.domain.car;

public class MyCar {

	private final CarName carName;
	private final int distance;
	public MyCar(CarName carName, int distance) {
		this.carName = carName;
		this.distance = distance;
	}

	public CarName getCarName() {
		return carName;
	}
	public String getName() {
		return carName.name();
	}

	public int getDistance() {
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

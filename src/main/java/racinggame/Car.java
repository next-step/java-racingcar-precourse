package racinggame;

import java.util.Objects;

public class Car {
	private CarName carName;
	private Distance distance;

	Car(String carName) {
		this.carName = new CarName(carName);
	}

	public void distance(int random) {
		if (Objects.isNull(this.distance)) {
			this.distance = new Distance();
		}
		this.distance.distance(random);
	}

	@Override
	public String toString() {
		return carName + " : " + distance;
	}
}

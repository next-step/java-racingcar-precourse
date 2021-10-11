package racinggame.domain;

public class CarStatus {
	private final String carName;
	private final int carPosition;

	public CarStatus(Car car) {
		this.carName = car.getName();
		this.carPosition = car.getPosition();
	}

	public String getCarName() {
		return carName;
	}

	public int getCarPosition() {
		return carPosition;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof CarStatus)) {
			return false;
		}
		return carName.equals(((CarStatus)o).getCarName()) && carPosition == ((CarStatus)o).getCarPosition();
	}
}

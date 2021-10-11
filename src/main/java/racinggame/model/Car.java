package racinggame.model;

/**
 * @auhor Kim JeongJin <kingroma92@gmail.com>
 * @version 1.0
 * @since 1.0
 */
public class Car {
	public CarName carName = new CarName();

	public CarDistance carDistance = new CarDistance();

	public void moveOrStop() {
		carDistance.moveOrStop();
	}
	
	public CarName getCarName() {
		return carName;
	}

	public void setCarName(CarName carName) {
		this.carName = carName;
	}

	public void setCarName(String carName) {
		this.carName.setCarName(carName);
	}
	
	public CarDistance getCarDistance() {
		return carDistance;
	}

	public void setCarDistance(CarDistance carDistance) {
		this.carDistance = carDistance;
	}

}

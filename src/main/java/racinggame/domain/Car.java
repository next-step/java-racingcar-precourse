package racinggame.domain;

public class Car {
	private CarName carName;
	private CarMove carMove;
	private CarPosition carPosition;

	public Car(String carName) {
		this.carName = new CarName(carName);
		this.carMove = new CarMove();
		this.carPosition = new CarPosition();
	}
}

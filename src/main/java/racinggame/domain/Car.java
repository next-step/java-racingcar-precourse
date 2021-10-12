package racinggame.domain;

public class Car {
	private static final String COLON = " : ";

	private CarName carName;
	private CarMove carMove;
	private CarPosition carPosition;

	public Car(String carName) {
		this.carName = new CarName(carName);
		this.carMove = new CarMove();
		this.carPosition = new CarPosition();
	}

	public void moveCar() {
		if (!carMove.checkMove()) {
			return;
		}
		carPosition.movePosition();
	}

	public String currentCars() {
		return this.carName.getCarName() + COLON + carPosition.getCarPosition();
	}

	public int currentCarsToInt(){
		return this.carPosition.getCarPositionLength();
	}
}

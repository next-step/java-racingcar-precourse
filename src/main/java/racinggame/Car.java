package racinggame;

public class Car {

	private CarName carName;
	private CarMove carMove;

	public Car(CarName carName, CarMove carMove) {
		this.carName = carName;
		this.carMove = carMove;
	}

	public CarStatus move() {
		if (carMove.isGo()) {
			return CarStatus.GO;
		}
		return CarStatus.STOP;
	}

	public String getCarName() {
		return carName.getCarName();
	}
}

package racinggame;

public class Car {

	private String carName;
	private int carMove;

	public Car(String carName, int carMove) {
		this.carName = carName;
		this.carMove = carMove;
	}

	public CarStatus move() {
		if (carMove >= 4) {
			return CarStatus.GO;
		}
		return CarStatus.STOP;
	}
}

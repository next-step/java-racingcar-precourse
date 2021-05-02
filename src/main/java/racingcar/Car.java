package racingcar;

public class Car {
	private CarName carName;
	private CarDistance carDistance;

	public Car(String carName) {
		this.carName = new CarName(carName);
		this.carDistance = new CarDistance();
	}

	public String getCarName() {
		return carName.getName();
	}

	public int move(int condition) {
		carDistance.move(condition);
		return carDistance.getDistance();
	}

	public void printNameAndDistance() {
		System.out.print(getCarName() + ": ");
		for (int i = 0; i < carDistance.getDistance(); i++) {
			System.out.print("-");
		}
		System.out.println();
	}
}

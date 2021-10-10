package racinggame;

public class Car {
	private CarName carName;

	Car(String carName) {
		this.carName = new CarName(carName);
	}

	@Override
	public String toString() {
		return "Car{" +
			"carName='" + carName + '\'' +
			'}';
	}
}

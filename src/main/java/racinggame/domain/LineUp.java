package racinggame.domain;
import java.util.ArrayList;
import java.util.List;

public class LineUp {
	private final List<Car> cars;

	public LineUp(List<Car> cars) {
		this.cars = cars;
	}

	public void drive() {
		for (Car car : cars) {
			car.drive();
		}
	}

	public List<Car> getCars() {
		System.out.println(cars);
		ArrayList<Car> newCars = new ArrayList<>(this.cars);
		System.out.println(newCars);

		return new ArrayList<>(this.cars);
	}
}

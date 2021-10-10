package racinggame.domain;
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

	public Record getRecord() {
		Record record = new Record();
		for (Car car : cars) {
			record.add(car);
		}

		return record;
	}
}

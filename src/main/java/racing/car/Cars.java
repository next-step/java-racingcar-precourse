package racing.car;

import java.util.ArrayList;
import java.util.List;

public class Cars {
	private List<Car> cars;

	public Cars(String namesWithDelimiter) {
		this.cars = new ArrayList<>();

		CarNames carNames = new CarNames(namesWithDelimiter);
		for (CarName carName : carNames.getNames()) {
			this.cars.add(new Car(carName));
		}
	}

	public List<Car> getCars() {
		return this.cars;
	}
}

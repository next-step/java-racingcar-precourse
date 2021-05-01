package racing;

import java.util.ArrayList;
import java.util.List;

public class Race {
	private List<Car> cars;
	private Round round;

	public Race(String namesWithDelimiter, int tryCount) {
		this.cars = new ArrayList<>();
		this.round = new Round(tryCount);

		CarNames carNames = new CarNames(namesWithDelimiter);
		for (CarName carName : carNames.getNames()) {
			this.cars.add(new Car(carName));
		}
	}

	public RaceResult start() {
		return null;
	}

	public List<Car> getCars() {
		return this.cars;
	}

	public Round getRound() {
		return this.round;
	}
}

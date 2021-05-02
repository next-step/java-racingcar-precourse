package racing;

import java.util.ArrayList;
import java.util.List;

public class Race {
	private Cars cars;
	private Round round;

	public Race(String namesWithDelimiter, int tryCount) {
		this.cars = new Cars(namesWithDelimiter);
		this.round = new Round(tryCount);
	}

	public RaceRecord startRace() {
		List<RoundRecord> roundRecords = new ArrayList<>();

		for (int i = 1; i <= round.getVal(); i++) {
			RoundRecord roundRecord = startRound();
			roundRecords.add(roundRecord);
		}

		return new RaceRecord(roundRecords);
	}

	private RoundRecord startRound() {
		List<CarRecord> carRecords = new ArrayList<>();

		for (Car car : cars.getCars()) {
			car.drive();
			CarRecord carRecord = CarRecord.from(car);
			carRecords.add(carRecord);
		}

		return new RoundRecord(carRecords);
	}

	public Cars getCars() {
		return this.cars;
	}

	public Round getRound() {
		return this.round;
	}
}

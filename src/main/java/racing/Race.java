package racing;

public class Race {
	private Cars cars;
	private Round round;

	public Race(String namesWithDelimiter, int tryCount) {
		this.cars = new Cars(namesWithDelimiter);
		this.round = new Round(tryCount);
	}

	public RaceResult start() {
		return null;
	}

	public Cars getCars() {
		return this.cars;
	}

	public Round getRound() {
		return this.round;
	}
}

package racinggame.domain;

public class Game {
	private final Cars cars;

	private Game(Cars cars) {
		this.cars = cars;
	}

	public static Game ready(Cars cars) {
		return new Game(cars);
	}

	public void start(Count count) {
		for (int i = 0; i < count.getValue(); i++) {
			cars.move();
		}
	}
}

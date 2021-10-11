package racinggame.domain;

import racinggame.dto.ResultDto;

public class Game {
	private final Cars cars;
	private final Histories histories;

	private Game(Cars cars) {
		this.cars = cars;
		this.histories = new Histories();
	}

	public static Game ready(Cars cars) {
		return new Game(cars);
	}

	public ResultDto start(Count count) {
		for (int i = 0; i < count.getValue(); i++) {
			cars.move();
			histories.log(this);
		}
		return ResultDto.of(this);
	}

	public Cars getCars() {
		return cars;
	}

	public Histories getHistories() {
		return histories;
	}
}

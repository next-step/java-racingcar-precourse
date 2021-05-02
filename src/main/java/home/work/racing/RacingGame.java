package home.work.racing;

import java.util.Collections;

import home.work.racing.plural.CarNames;
import home.work.racing.plural.PlayerCars;
import home.work.racing.wrap.CarName;
import home.work.racing.wrap.GameCount;
import home.work.racing.wrap.RandomResult;

public class RacingGame {

	private static final int MOVEABLE_MIN_NUM = 4;
	private GameCount gameCount;
	private PlayerCars cars;
	private CommandLineInterface cli;

	public RacingGame(CommandLineInterface cli) {
		if (cli == null) {
			throw new IllegalArgumentException("cli 없음");
		}
		this.cli = cli;
	}

	public void play() {
		this.init();
		this.start();
		this.showResult();
	}

	void init() {
		CarNames carNames = this.cli.receiveCarNames();
		this.cars = this.makePlayerCars(carNames);
		if (this.cars == null) {
			throw new RuntimeException("차목록 만들기 실패");
		}
		this.gameCount = this.cli.receiveGameCount();
		if (this.gameCount == null) {
			throw new RuntimeException("시도 회수 설정 실패");
		}
		this.cli.printLineSeperate();
	}

	void start() {
		for (int i = 0; i < this.gameCount.getCount(); i++) {
			this.roll();
		}
	}

	void roll() {
		for (PlayerCar car : this.cars.getCars()) {
			this.check(RandomUtils.random(), car);
			this.cli.printCarMoving(car);
		}
		cli.printLineSeperate();
	}

	void check(RandomResult randomResult, PlayerCar car) {
		if (randomResult.getNum() >= MOVEABLE_MIN_NUM) {
			car.moving();
		}
	}

	void showResult() {
		PlayerCar max = Collections.max(this.cars.getCars(), (a, b) -> {
			return a.getMove().getMove() - b.getMove().getMove();
		});

		RaceWinners winners = new RaceWinners(max.getMove());
		for (PlayerCar car : this.cars.getCars()) {
			winners.addCar(car);
		}
		this.cli.printWinners(winners);
	}

	private PlayerCars makePlayerCars(CarNames carNames) {
		PlayerCars cars = new PlayerCars();
		for (CarName name : carNames.getNames()) {
			cars.addCar(new PlayerCar(name));
		}
		return cars;
	}

}

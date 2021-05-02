package home.work.racing;

import home.work.racing.plural.CarNames;
import home.work.racing.plural.PlayerCars;
import home.work.racing.wrap.CarName;
import home.work.racing.wrap.GameCount;

public class RacingGame {

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

	private PlayerCars makePlayerCars(CarNames carNames) {
		PlayerCars cars = new PlayerCars();
		for (CarName name : carNames.getNames()) {
			cars.addCar(new PlayerCar(name));
		}
		return cars;
	}

}

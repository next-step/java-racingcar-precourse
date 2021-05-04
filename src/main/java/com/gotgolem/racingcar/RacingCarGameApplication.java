package com.gotgolem.racingcar;

import com.gotgolem.racingcar.asset.Cars;
import com.gotgolem.racingcar.service.CarService;
import com.gotgolem.racingcar.service.ConsoleUiService;
import com.gotgolem.racingcar.service.PlayerService;

public class RacingCarGameApplication {

	private final ConsoleUiService consoleUiService;
	private final PlayerService playerService;
	private final CarService carService;

	private RacingCarGameApplication() {
		this.consoleUiService = new ConsoleUiService();
		this.playerService = new PlayerService();
		this.carService = new CarService();
	}

	private void start() {
		final Cars cars = playerService.toCars(consoleUiService.requestCarNames());
		final int matchCount = consoleUiService.requestMatchCount();

		System.out.println("\n실행 결과");
		for (int i = 0; i < matchCount; i++) {
			carService.match(cars);
			consoleUiService.printMatchResult(cars);
		}
		
		consoleUiService.printWinners(cars.getTopMileageCars());
	}

	public static void main(String[] args) {
		final RacingCarGameApplication gameApplication = new RacingCarGameApplication();
		gameApplication.start();
	}

}

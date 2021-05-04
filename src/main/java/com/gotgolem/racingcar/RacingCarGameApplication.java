package com.gotgolem.racingcar;

import java.util.InputMismatchException;

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
		Cars cars;
		do {
			cars = requestCars();
		} while (cars == null);

		int matchCount;
		do {
			matchCount = requestMatchCount();
		} while (matchCount < 1);

		System.out.println("\n실행 결과");
		for (int i = 0; i < matchCount; i++) {
			carService.match(cars);
			consoleUiService.printMatchResult(cars);
		}

		consoleUiService.printWinners(cars.getTopMileageCars());
	}

	private Cars requestCars() {
		try {
			return playerService.toCars(consoleUiService.requestCarNames());
		} catch (IllegalArgumentException e) {
			consoleUiService.printMessage("쉼표로 구분하여 10대 이하의 자동차 이름을 입력해주세요. (자동차 이름은 최대 5자입니다)");
			return null;
		}
	}

	private int requestMatchCount() {
		try {
			return Integer.parseInt(consoleUiService.requestMatchCount());
		} catch (IllegalArgumentException | InputMismatchException e) {
			consoleUiService.printMessage("횟수는 1 이상을 입력해주세요.");
			return -1;
		}
	}

	public static void main(String[] args) {
		final RacingCarGameApplication gameApplication = new RacingCarGameApplication();
		gameApplication.start();
	}

}

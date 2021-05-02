package home.work.racing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import home.work.racing.plural.CarNames;
import home.work.racing.plural.PlayerCars;
import home.work.racing.wrap.CarName;
import home.work.racing.wrap.GameCount;

public class CommandLineInterface {

	private static Scanner scanner;

	public CommandLineInterface(Scanner input) {
		if (input == null)
			throw new IllegalArgumentException("입력기가 없습니다.");
		scanner = input;
	}

	public CarNames receiveCarNames() {
		System.out.println("경주할자동차이름을입력하세요.(이름은쉼표(,)기준으로구분)");
		String carNameStr = scanner.next();
		String[] splitedNames = carNameStr.split(",");
		return this.makeCarNames(Arrays.asList(splitedNames));
	}

	private CarNames makeCarNames(List<String> carNameList) {
		if (carNameList == null) {
			throw new IllegalArgumentException("입력된 차이름이 없음");
		}
		CarNames carNames = new CarNames();
		for (String name : carNameList) {
			carNames.addCarName(new CarName(name));
		}
		return carNames;
	}

	public GameCount receiveGameCount() {
		System.out.println("시도할 회수는 몇회인가요?");
		return new GameCount(scanner.nextInt());
	}

	public void printLineSeperate() {
		System.out.println();
	}

	public void printCarMoving(PlayerCar car) {
		if (car == null) {
			throw new IllegalArgumentException("차가 없음");
		}
		System.out.print(car.getName().getName() + " : ");
		for (int i = 0; i < car.getMove().getMove(); i++) {
			System.out.print("-");
		}
		System.out.println();
	}

	public void printWinners(RaceWinners winners) {
		Optional.ofNullable(winners).map(RaceWinners::getCars).map(PlayerCars::getCars).filter(list -> list.size() > 0)
				.orElseThrow(() -> new RuntimeException("우승자가 없습니다."));
		List<String> winnerNames = new ArrayList<>();
		for (PlayerCar car : Optional.ofNullable(winners).map(RaceWinners::getCars).map(PlayerCars::getCars)
				.orElseThrow(() -> new RuntimeException("우승자 자동차가 없음"))) {
			winnerNames.add(Optional.ofNullable(car).map(PlayerCar::getName).map(CarName::getName)
					.orElseThrow(() -> new RuntimeException("우승자 이름이 없음")));
		}
		System.out.println(String.join(", ", winnerNames) + "가 최종 우승했습니다.");
	}

}

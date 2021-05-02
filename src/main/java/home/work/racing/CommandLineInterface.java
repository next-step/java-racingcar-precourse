package home.work.racing;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import home.work.racing.plural.CarNames;
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

}

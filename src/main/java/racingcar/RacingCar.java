package racingcar;

import static racingcar.Utils.*;

import java.util.Iterator;

public class RacingCar {
	private Cars cars;
	private Round round;

	public void run() {
		initCars();
		initRound();
		start();
		printWinner();
	}

	private void initCars() {
		try {
			System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,)기준으로 구분)");
			cars = new Cars(splitByComma(getStringInput()));
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
			initCars();
		}
	}

	private void initRound() {
		try {
			System.out.println("시도할 횟수는 몇 회인가요?");
			round = new Round(Integer.parseInt(getStringInput()));
		} catch (NumberFormatException exception) {
			System.out.println("정수를 입력하세요.");
			initRound();
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
			initRound();
		}
	}

	private void start() {
		for (int i = 0; i < round.getCount(); i++) {
			cars.moveCars();
			cars.printCars();
			System.out.println();
		}
	}

	private void printWinner() {
		Iterator<Car> iterator = cars.findWinners().iterator();
		while (iterator.hasNext()) {
			System.out.print(iterator.next().getCarName());
			printComma(iterator);
		}
		System.out.println("가 최종 우승했습니다.");
	}

	private void printComma(Iterator<Car> iterator) {
		if (iterator.hasNext()) {
			System.out.print(", ");
		}
	}
}

package racingcar;

import java.util.Random;
import java.util.Scanner;

public class RacingGame {
	static int moveCount;
	static Cars cars;

	static void setGameCount(String count) {
		moveCount = Integer.parseInt(count);
	}

	public static void main(String[] args) {
		gameStart();
	}

	private static void gameStart() {
		getCarsFromUser();
		getGameCountFromUser();
		System.out.println(GameMessage.RESULT_MESSAGE);
		repeatRound();
		System.out.println(getWinners());
	}

	static void getCarsFromUser() {
		System.out.println(GameMessage.START_MESSAGE);
		Scanner scan = new Scanner(System.in);
		String carsText = scan.next();

		getCarsFromText(carsText);

		if (cars.getCarSize() == 0) {
			System.err.println(GameMessage.ERROR_CARS_MESSAGE);
			getCarsFromUser();
		}
	}

	private static void getCarsFromText(String carsText) {
		cars = new Cars();
		CarLamda carLamda = (String name) -> {
			return ValidateUtils.isLessThan6Char(name) ? new Car(name) : null;
		};
		for (String carText : carsText.split(",")) {
			cars.addCar(carLamda.makeCar(carText));
			cars.getCars().remove(null);
		}
	}

	static void getGameCountFromUser() {
		Scanner scan = new Scanner(System.in);
		System.out.println(GameMessage.ASK_COUNT_MESSAGE);
		String count = scan.next();

		while (ValidateUtils.isNotNumber(count)) {
			System.err.println(GameMessage.ERROR_NUMBER_MESSAGE);
			count = scan.next();
		}
		setGameCount(count);
	}

	private static void repeatRound() {
		for (int i = 0; i < moveCount; i++) {
			repeatCars();
			System.out.println();
		}
	}

	private static void repeatCars() {
		for (Car car : cars.getCars()) {
			MoveCar mCar = makeMoveCar();
			isCarCanGo(car, mCar);
			System.out.println(String.format("%s:%s", car.getName(), car.getMoves()));
		}
	}

	private static MoveCar makeMoveCar() {
		Random random = new Random();
		return new MoveCar(random.nextInt(10));
	}

	private static void isCarCanGo(Car car, MoveCar mCar) {
		if (mCar.isGo()) {
			car.go();
		}
	}

	private static String getWinners() {
		String winners = cars.getWinnersName(moveCount);
		if (winners.length() == 0) {
			return GameMessage.NO_WINNER;
		}
		return GameMessage.getWinnerMessage(winners);
	}
}
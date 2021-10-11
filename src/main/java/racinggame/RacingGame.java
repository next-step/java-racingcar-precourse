package racinggame;

import nextstep.utils.Console;

public class RacingGame {
	private RacingCars cars;
	private RacingCount count;

	public RacingGame() {
		CarNames carNames = null;
		RacingCount count = null;
		while (carNames == null) {
			carNames = getCarNames();
		}
		while (count == null) {
			count = getRacingCount();
		}
		this.cars = new RacingCars(carNames);
		this.count = count;
	}

	public void play() {
		System.out.println("실행 결과");
		for (int i = 0; i < count.getCount(); i++) {
			cars.move();
			System.out.println(cars);
			System.out.println();
		}
		System.out.printf("최종 우승자는 %s 입니다.%n", cars.winners());
	}

	private RacingCount getRacingCount() {
		System.out.println("시도할 회수는 몇회인가요?");
		String userInput = Console.readLine();

		try {
			return new RacingCount(userInput);
		} catch (NumberFormatException e) {
			System.out.println("[ERROR] 숫자를 입력 해주세요.");
			return null;
		}
	}

	private CarNames getCarNames() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		String userInput = Console.readLine();

		try {
			return new CarNames(userInput);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
}

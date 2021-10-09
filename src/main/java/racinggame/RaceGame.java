package racinggame;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import nextstep.utils.Console;

public class RaceGame {

	public void start() {

		Cars cars = init();
		int count = readCount();
		race(cars, count);
		printWinners(cars);
	}

	private void printWinners(Cars cars) {
		System.out.println(getWinner(cars));
	}

	private String getWinner(Cars cars) {
		StringBuffer sb = new StringBuffer();
		List<Car> winners = cars.findWinners();
		for (int i = 0; i < winners.size(); i++) {
			sb.append(winners.get(i).getName());
			if (i != winners.size() - 1) {
				sb.append(",");
			}
		}
		return String.format("최종 우승자는 %s 입니다.", sb.toString());
	}

	private void race(Cars cars, int count) {

		Strategy generator = new RandomStrategy();
		System.out.println("실행 결과");
		do {
			cars.race(generator);
		} while (--count > 0);

	}

	private List<Car> createCarList(String[] names) {

		List<Car> cars = new ArrayList<Car>();
		for (String name : names) {
			cars.add(new Car(name));
		}
		return cars;
	}

	private Cars init() {

		while (true) {
			try {
				String[] names = readNames();
				List<Car> carList = createCarList(names);
				return new Cars(carList);
			} catch (NoSuchElementException e) {
				System.out.println(e.getMessage());
				continue;
			}
		}
	}

	private int readCount() {
		System.out.println("시도할 회수는 몇회인가요?");
		return Integer.parseInt(Console.readLine());
	}

	private String[] readNames() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		return Console.readLine().split(",");
	}
}

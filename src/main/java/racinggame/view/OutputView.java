package racinggame.view;

import racinggame.model.Car;

import java.util.List;
import java.util.StringJoiner;

public class OutputView {
	private static final String PRINT_RESULT = "실행 결과";
	private static final String PRINT_CARS = "%s : %s";
	private static final String PRINT_WINNERS = "최종 우승자는 %s 입니다.";

	public void printResult() {
		System.out.println();
		System.out.println(PRINT_RESULT);
	}

	public void printCars(List<Car> cars) {
		for (Car car : cars) {
			System.out.println(String.format(PRINT_CARS, car.getName(), convertDistance(car.getDistance())));
		}
		System.out.println();
	}

	private String convertDistance(int distance) {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < distance; i++) {
			stringBuilder.append("-");
		}
		return stringBuilder.toString();
	}

	public void printWinners(List<Car> cars) {
		StringJoiner winnersName = new StringJoiner(",");
		for (Car car : cars) {
			winnersName.add(car.getName());
		}
		System.out.println(String.format(PRINT_WINNERS, winnersName));
	}
}

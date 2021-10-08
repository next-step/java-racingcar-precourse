package racinggame.view;

import java.util.List;
import java.util.StringJoiner;

import racinggame.model.Car;

public class OutputView {

	private static final String RESULT_MESSAGE = "실행결과";
	private static final String COLON_MESSAGE = " : ";
	private static final int START_INCLUSIVE = 0;
	private static final String DISTANCE_EXPRESSION = "-";
	private static final String FINAL_WINNERS_MESSAGE = "최종 우승자는 %s 입니다.";
	private static final String DELIMITER = ",";

	public static void printResult() {
		System.out.println(RESULT_MESSAGE);
	}

	public static void printResultByRound(List<Car> cars) {
		for (Car car : cars) {
			System.out.println(car.getName() + COLON_MESSAGE + convertDistance(car.getDistance()));
		}
		System.out.println();
	}

	private static String convertDistance(int distance) {
		StringBuilder convertDistance = new StringBuilder();
		for (int i = START_INCLUSIVE; i < distance; i++) {
			convertDistance.append(DISTANCE_EXPRESSION);
		}
		return convertDistance.toString();
	}

	public static void printWinnerCars(List<Car> winnerCars) {
		System.out.printf(FINAL_WINNERS_MESSAGE + System.lineSeparator(), getWinnersName(winnerCars));
	}

	private static String getWinnersName(List<Car> winnerCars) {
		StringJoiner cars = new StringJoiner(DELIMITER);
		for (Car winnerCar : winnerCars) {
			cars.add(winnerCar.getName());
		}
		return cars.toString();
	}
}

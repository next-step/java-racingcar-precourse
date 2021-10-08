package racinggame.view;

import java.util.List;

import racinggame.model.Car;

public class OutputView {

	private static final String RESULT_MESSAGE = "실행결과";
	private static final String COLON_MESSAGE = " : ";
	private static final int START_INCLUSIVE = 0;
	private static final String DISTANCE_EXPRESSION = "-";

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
}

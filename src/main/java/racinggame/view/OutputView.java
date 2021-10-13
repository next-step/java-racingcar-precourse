package racinggame.view;

import java.util.ArrayList;
import java.util.List;

import racinggame.domain.Car;
import racinggame.domain.Cars;

public class OutputView {

	private static final String PROGRESS_ICON = "-";

	private static final String START_BEFORE_MESSAGE = "실행 결과";

	private static final String WINNER_MESSAGE = "최종 우승자는 %s 입니다%n";

	public void showCurrentDrivenDistance(Cars cars){

		for (Car car : cars.getCars()) {
			String name = car.getCarName().getName();
			int currentDrivenDistance = car.getDrivenDistance();
			System.out.printf("%s : %s%n", name, viewProgress(currentDrivenDistance));
		}

	}

	private String viewProgress(final int currentDrivenDistance) {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < currentDrivenDistance; i++) {
			stringBuilder.append(PROGRESS_ICON);
		}
		return stringBuilder.toString();
	}

	public void printErrorMessage(final String message) {
		System.out.println("[ERROR] " + message);
	}

	public void showExecuteResultMessage() {
		System.out.println(START_BEFORE_MESSAGE);
	}

	public void showWinner(final List<Car> announceWinners) {
		System.out.printf(WINNER_MESSAGE, joinWinners(announceWinners, ","));
	}

	private String joinWinners(final List<Car> announceWinners, final String delimiter) {
		return String.join(delimiter, toCarNames(announceWinners));
	}

	private List<String> toCarNames(final List<Car> cars) {
		List<String> carNames = new ArrayList<>();
		for (Car car : cars) {
			carNames.add(car.getCarName().getName());
		}

		return carNames;
	}
}
